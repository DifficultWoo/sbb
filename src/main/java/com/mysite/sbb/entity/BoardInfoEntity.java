package com.mysite.sbb.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "board_info")
public class BoardInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bi_seq") private Long biSeq;

    @Column(name = "bi_mi_seq") private Long biMiSeq;
    @Column(name = "bi_title") private String biTitle;
    @Column(name = "bi_detail") private String biDetail;
    @Column(name = "bi_reg_dt") private LocalDateTime biRegDt;
    @Column(name = "bi_edit_dt") private LocalDateTime biEditDt;
    @Column(name = "bi_views") private Integer biViews;
    @Column(name = "bi_status") private Integer biStatus;
}
