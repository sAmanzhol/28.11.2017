package com.example.mk123_pc.khan.util;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author Beksultan
 */
public class RequestManager {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/jpg");
    private static final Integer NO_INTERNET = 4;
    private static final String NO_INTERNET_ERROR_TEXT = "no internet";
    public static final Integer ERROR_UNAUTHORIZED = 401;

    private Call mCall;
    private Context mContext;
    private Handler mHandler;

    /*
     * Listener for actions after thread is completed
     */
    private OnStatusListener mListener;

    public interface OnStatusListener {
        void onSuccess(String data);

        void onFailure(int errorCode, String error);
    }

    public void setOnStatusListener(OnStatusListener onStatusListener) {
        mListener = onStatusListener;
    }

    /*
     * Constructor
     */
    public RequestManager(Context context) {
        mContext = context;
        mHandler = new Handler(mContext.getMainLooper());
    }


    /*
     * Methods
     */
    public void postImage(String url, Uri uri) {
        File file = new File(uri.getPath());
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addPart(
                        Headers.of("Content-Disposition", "form-data; name=\"avatar\""),
                        RequestBody.create(MEDIA_TYPE_JPG, file))
                .build();

        makeRequest(url, requestBody,Global.ACCESS_TOKEN,Global.REFRESH_TOKEN);
    }


    /**
     * make a post request
     * @param url web address
     * @param jsonObject post body
     */
    public void post(String url, JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(JSON, jsonObject.toString());
        makeRequest(url, requestBody,Global.ACCESS_TOKEN,Global.REFRESH_TOKEN);
    }


    /**
     * make a get request
     * @param url web address
     */
    public void get(String url) {
        makeRequest(url, null,Global.ACCESS_TOKEN,Global.REFRESH_TOKEN);
    }

    private void makeRequest(String url, RequestBody requestBody,String accessToken, String refreshToken) {
        if (isNetworkAvailable()) {
            call(new OkHttpClient(), getRequest(url, requestBody,accessToken,refreshToken));
        } else {
            mListener.onFailure(NO_INTERNET, NO_INTERNET_ERROR_TEXT);
        }
    }

    private Request getRequest(String url, RequestBody requestBody, String accessToken, String refreshToken) {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);

        if (accessToken != null) {
            requestBuilder.addHeader("Access-Token", Global.ACCESS_TOKEN);
            requestBuilder.addHeader("Refresh-Token", Global.REFRESH_TOKEN);
        }

        if (requestBody != null) {
            requestBuilder.post(requestBody);
        }
        return requestBuilder.build();
    }

    private void call(OkHttpClient client, Request request) {
        mCall = client.newCall(request);
        mCall.enqueue(new Callback() {

            // Called when the request could not be executed due to cancellation, a connectivity problem or timeout.
            @Override
            public void onFailure(@NonNull Call call, @NonNull final IOException e) {
                onFailureListener(e);
            }

            // Called when the HTTP response was successfully returned by the remote server.
            @Override
            public void onResponse(@NonNull Call call, @NonNull final Response response) throws IOException {
                onResponseListener(response);
            }
        });
    }


    private void onFailureListener(final IOException e) {
        if (!mCall.isCanceled())
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mListener.onFailure(NO_INTERNET, e.getLocalizedMessage());
                }
            });
    }

    private void onResponseListener(final Response response) {
        if (!mCall.isCanceled()) {
            String data = null;
            try {
                data = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            final String finalData = data;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (response.isSuccessful()) {
                        mListener.onSuccess(finalData);
                    } else {
                        mListener.onFailure(response.code(), finalData);
                    }
                }
            });
        }
    }

    /*
     * Helper functions
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    private void runOnUiThread(Runnable runnable) {
        mHandler.post(runnable);
    }

    // cancel the call
    public void cancelCall() {
        if (mCall != null && mCall.isExecuted()) mCall.cancel();
    }
}