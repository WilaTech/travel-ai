package com.wilatech.travelai.dto.gemini;

import java.util.List;

public record RequestContent(
        List<RequestPart> parts
) {
}
