package cf.varazdinevents.croatiaevents.data.api;

import java.util.List;

import cf.varazdinevents.croatiaevents.data.api.responses.EventResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by antonio on 25/07/17.
 */

public interface RestService {
    @GET("events/city/{cityId}")
    Single<ApiResponse<List<EventResponse>>> getEventsByCity(@Path("cityId") Integer cityId);
}
