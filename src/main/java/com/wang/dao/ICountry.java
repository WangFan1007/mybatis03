package com.wang.dao;

import com.wang.domain.Country;

import java.util.List;

public interface ICountry {

    Country getCounreyByID(Integer id);
    List<Country> getAll();
}
