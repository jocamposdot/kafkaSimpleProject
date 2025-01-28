package com.jrcofuhr.kafkaconsumertwo.record;

import java.math.BigDecimal;

public record OrderRecord(Long id, String name, String description, BigDecimal amount) {
    
}
