package com.christian.pray.DTO.request;

import com.christian.pray.model.enums.PrayType;


public record PrayRequest(String targetPray, String description, PrayType prayType) { }
