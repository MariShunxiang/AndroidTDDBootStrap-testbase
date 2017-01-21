package com.github.piasy.bootstrap.testbase;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Response;

/**
 * Created by Piasy{github.com/Piasy} on 17/10/2016.
 */

public final class TestUtil {
    private TestUtil() {
        // no instance
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static HttpException nonApiError() {
        return new HttpException(Response.error(404, new ResponseBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("application/json");
            }

            @Override
            public long contentLength() {
                return 4;
            }

            @Override
            public BufferedSource source() {
                try {
                    return new Buffer().readFrom(new ByteArrayInputStream("null".getBytes()));
                } catch (IOException e) {
                    return null;
                }
            }
        }));
    }

    public static HttpException invalidApiError() {
        return new HttpException(Response.error(404, new ResponseBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("application/json");
            }

            @Override
            public long contentLength() {
                return 2;
            }

            @Override
            public BufferedSource source() {
                try {
                    return new Buffer().readFrom(new ByteArrayInputStream("{}".getBytes()));
                } catch (IOException e) {
                    return null;
                }
            }
        }));
    }

    public static HttpException apiError() {
        return new HttpException(Response.error(404, new ResponseBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("application/json");
            }

            @Override
            public long contentLength() {
                return provideGithubAPIErrorStr().length();
            }

            @Override
            public BufferedSource source() {
                try {
                    return new Buffer().readFrom(new ByteArrayInputStream(
                            provideGithubAPIErrorStr().getBytes()));
                } catch (IOException e) {
                    return null;
                }
            }
        }));
    }

    public static String projectRoot() {
        final String cwd = new File(".").getAbsolutePath();
        return cwd.substring(0, cwd.lastIndexOf("AndroidTDDBootStrap") + 20);
    }

    private static String provideGithubAPIErrorStr() {
        return "{\"message\":\"Validation Failed\",\"errors\":[{\"resource\":\"Issue\"," +
               "\"field\":\"title\",\"code\":\"missing_field\"}]}";
    }
}
