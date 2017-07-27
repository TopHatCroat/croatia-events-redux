package cf.varazdinevents.croatiaevents.data.api;

import android.support.annotation.Nullable;

import com.google.common.base.Strings;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by antonio on 26/07/17.
 */

public class ApiResponse<T> {
    public final int code;
    @Nullable
    public final T body;
    @Nullable
    public final String errorMessage;

    public ApiResponse(Throwable err) {
        this.code = 500;
        this.body = null;
        this.errorMessage = err.getMessage();
    }

    public ApiResponse(Response<T> response) {
        code = response.code();
        if (response.body() != null) {
            body = response.body();
            errorMessage = null;
        } else {
            String msg = null;
            if (response.errorBody() != null) {
                try {
                    msg = response.errorBody().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Strings.isNullOrEmpty(msg)) {
                msg = response.message();
            }
            errorMessage = msg;
            body = null;
        }
    }

    public boolean isSuccessful() {
        return this.code >= 200 && this.code < 300;
    }
}
