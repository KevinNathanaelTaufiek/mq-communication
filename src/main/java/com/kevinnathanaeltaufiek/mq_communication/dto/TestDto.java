package com.kevinnathanaeltaufiek.mq_communication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDto implements Serializable {
    private String nama;
    private Long tinggi;
    private LocalDateTime tanggalLahir = LocalDateTime.now();
}
