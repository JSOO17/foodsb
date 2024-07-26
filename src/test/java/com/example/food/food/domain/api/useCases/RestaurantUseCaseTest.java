package com.example.food.food.domain.api.useCases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.example.food.food.domain.exception.EmptyFieldException;
import com.example.food.food.domain.exception.InvalidCellphoneException;
import com.example.food.food.domain.exception.InvalidNameRestaurantException;
import com.example.food.food.domain.models.Restaurant;
import com.example.food.food.domain.spi.persistence.IRestaurantPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RestaurantUseCaseTest {

    @Mock
    private IRestaurantPersistencePort restaurantPersistencePort;

    @InjectMocks
    private RestaurantUseCase restaurantUseCase;

    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant(1L, "Test Restaurant", "123 Test St", 1L, "1234567890", "http://test.com/logo.png", 123456);
    }

    @Test
    void testGetAllRestaurants() {
        List<Restaurant> restaurantList = Collections.singletonList(restaurant);
        when(restaurantPersistencePort.getAllRestaurants()).thenReturn(restaurantList);

        List<Restaurant> result = restaurantUseCase.getAllRestaurants();

        assertEquals(1, result.size());
        assertEquals("Test Restaurant", result.get(0).getName());
        verify(restaurantPersistencePort, times(1)).getAllRestaurants();
    }

    @Test
    void testGetRestaurantById() {
        when(restaurantPersistencePort.getRestaurantById(1L)).thenReturn(Optional.of(restaurant));

        Optional<Restaurant> result = restaurantUseCase.getRestaurantById(1L);

        assertNotNull(result);
        assertEquals("Test Restaurant", result.get().getName());
        verify(restaurantPersistencePort, times(1)).getRestaurantById(1L);
    }

    @Test
    void testCreateRestaurant() {
        when(restaurantPersistencePort.createRestaurant(any(Restaurant.class))).thenReturn(restaurant);

        Restaurant result = restaurantUseCase.createRestaurant(restaurant);

        assertNotNull(result);
        assertEquals("Test Restaurant", result.getName());
        verify(restaurantPersistencePort, times(1)).createRestaurant(any(Restaurant.class));
    }

    @Test
    void testUpdateRestaurant() {
        when(restaurantPersistencePort.updateRestaurant(eq(1L), any(Restaurant.class))).thenReturn(restaurant);

        Restaurant result = restaurantUseCase.updateRestaurant(1L, restaurant);

        assertNotNull(result);
        assertEquals("Test Restaurant", result.getName());
        verify(restaurantPersistencePort, times(1)).updateRestaurant(eq(1L), any(Restaurant.class));
    }

    @Test
    void testEmptyNameThrowsException() {
        assertThrows(EmptyFieldException.class, () -> {
            new Restaurant(1L, "", "123 Test St", 1L, "1234567890", "http://test.com/logo.png", 123456);
        });
    }

    @Test
    void testInvalidNameThrowsException() {
        assertThrows(InvalidNameRestaurantException.class, () -> {
            new Restaurant(1L, "123456", "123 Test St", 1L, "1234567890", "http://test.com/logo.png", 123456);
        });
    }

    @Test
    void testEmptyCellphoneThrowsException() {
        assertThrows(EmptyFieldException.class, () -> {
            new Restaurant(1L, "Test Restaurant", "123 Test St", 1L, "", "http://test.com/logo.png", 123456);
        });
    }

    @Test
    void testInvalidCellphoneThrowsException() {
        assertThrows(InvalidCellphoneException.class, () -> {
            new Restaurant(1L, "Test Restaurant", "123 Test St", 1L, "12345abc", "http://test.com/logo.png", 123456);
        });
    }

    @Test
    void testValidRestaurant() {
        Restaurant restaurant = new Restaurant(1L, "Test Restaurant", "123 Test St", 1L, "1234567890", "http://test.com/logo.png", 123456);

        assertNotNull(restaurant);
        assertEquals("Test Restaurant", restaurant.getName());
        assertEquals("1234567890", restaurant.getCellphone());
    }
}
