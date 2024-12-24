package com.yiqiyun.translateapi.untils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * HTTP 请求工具类
 * 用于发送 GET 和 POST 请求
 *
 * @author 17Yuns
 */
public class HttpRequest {
    private final OkHttpClient okHttpClient;

    // 构造方法
    public HttpRequest() {
        this.okHttpClient = new OkHttpClient.Builder()
                .build();
    }

    // 回调接口，用于通知请求结果
    public interface ResponseCallback {
        void onResponse(String result);

        void onFailure(IOException e);
    }

    /**
     * 发送 GET 请求
     *
     * @param url      请求 URL
     * @param headers  请求头
     * @param callback 回调接口
     */
    public void sendGetRequest(String url, Headers headers, ResponseCallback callback) {
        Request request = new Request.Builder()
                .headers(headers)
                .url(url)
                .get()
                .build();

        // 调用通用的请求处理方法
        sendRequest(request, callback);
    }

    /**
     * 发送 POST 请求
     *
     * @param url         请求 URL
     * @param headers     请求头
     * @param requestBody 请求体
     * @param callback    回调接口
     */
    public void sendPostRequest(String url, Headers headers, RequestBody requestBody, ResponseCallback callback) {
        Request request = new Request.Builder()
                .headers(headers)
                .url(url)
                .post(requestBody)
                .build();

        // 调用通用的请求处理方法
        sendRequest(request, callback);
    }

    /**
     * 通用的请求处理方法
     *
     * @param request  OkHttp 请求对象
     * @param callback 回调接口
     */
    private void sendRequest(Request request, ResponseCallback callback) {
        // 异步请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                // 请求失败，通知回调
                callback.onFailure(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    // 判断响应是否成功
                    if (response.isSuccessful() && response.body() != null) {
                        // 成功响应，返回数据
                        callback.onResponse(response.body().string());
                    } else {
                        // 响应失败
                        callback.onFailure(new IOException("Unexpected code " + response));
                    }
                } finally {
                    // 确保关闭响应体，避免资源泄漏
                    if (response.body() != null) {
                        response.body().close();
                    }
                }
            }
        });
    }

    /**
     * 发送同步 GET 请求
     *
     * @param url     请求 URL
     * @param headers 请求头
     * @return 响应字符串
     * @throws IOException 网络异常
     */
    public String sendSyncGetRequest(String url, Headers headers) throws IOException {
        Request request = new Request.Builder()
                .headers(headers)
                .url(url)
                .get()
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }

    /**
     * 发送同步 POST 请求
     *
     * @param url         请求 URL
     * @param headers     请求头
     * @param requestBody 请求体
     * @return 响应字符串
     * @throws IOException 网络异常
     */
    public String sendSyncPostRequest(String url, Headers headers, RequestBody requestBody) throws IOException {
        Request request = new Request.Builder()
                .headers(headers)
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }
}
