package com.zonner93.service.web_client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WebClientServiceImpl implements WebClientService{
    private final RestTemplate restTemplate;

}
