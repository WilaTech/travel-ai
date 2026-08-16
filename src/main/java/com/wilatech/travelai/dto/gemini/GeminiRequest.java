package com.wilatech.travelai.dto.gemini;

import java.util.List;

public record GeminiRequest(
        List<Content> contents
) {
}
