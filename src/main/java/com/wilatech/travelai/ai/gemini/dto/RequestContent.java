package com.wilatech.travelai.ai.gemini.dto;

import java.util.List;

public record RequestContent(
        List<RequestPart> parts
) {
}
