package com.java.ratingsdataservice.resources;

import com.java.ratingsdataservice.models.Rating;
import com.java.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {

        return new Rating(movieId, 4);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        /** using a list as return type is not recommended. Better to put that list in an object and pass */
        List<Rating> ratings = Arrays.asList(
                new Rating("123", 4),
                new Rating("124", 3));

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;


    }

}
