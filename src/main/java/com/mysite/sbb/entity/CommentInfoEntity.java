package com.mysite.sbb.entity;

import java.time.LocalDateTime;

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
@Table(name = "comment_info")
public class CommentInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ci_seq") 
    private Long ciSeq;
    
    @Column(name = "ci_content")
    private String ciContent;

    @Column(name = "ci_reg_dt")
    private LocalDateTime ciRegDt;

    @Column(name = "ci_edit_dt")
    private LocalDateTime ciEditDt;

    @Column(name = "ci_status")
    private Integer ciStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ci_mi_seq")
    private MemberInfoEntity memberInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ci_bi_seq")
    private BoardInfoEntity boardInfo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ci_ci_seq")
    private CommentInfoEntity commentInfo;

}
