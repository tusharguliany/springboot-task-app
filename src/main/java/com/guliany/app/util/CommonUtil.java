package com.guliany.app.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.guliany.app.dto.ResponseDTO;

public class CommonUtil {

	public static ResponseDTO getResponse(String key, Object value) {
		Map<String, Object> response = new HashMap<>();
		response.put(key, value);
		ResponseDTO dto = new ResponseDTO();
		dto.setData(response);
		dto.setTime(LocalDateTime.now());
		return dto;
	}

}
