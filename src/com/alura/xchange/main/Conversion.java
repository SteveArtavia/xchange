package com.alura.xchange.main;

public record Conversion(
        String result,
        String time_last_update_utc,
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result
) {
}
