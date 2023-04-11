package com.mysite.sbb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "board_likes")
public class BoardLikesEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bl_seq")
    private Long blSeq;

    @Column(name = "bl_status")
    private Integer blStatus;

    @ManyToOne(fetch = FetchType.LAZY) @JsonIgnore
    @JoinColumn(name = "bl_mi_seq")
    private MemberInfoEntity memberInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bl_bi_seq")
    private BoardInfoEntity boardInfo;
}
