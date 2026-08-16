package com.wilatech.travelai.dto.gemini;

import java.util.List;

public record ResponseContent(
        List<ResponsePart> parts
) {
}
