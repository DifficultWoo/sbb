package com.mysite.sbb.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name = "bi_seq")
    private Long biSeq;

    @Column(name = "bi_title")
    private String biTitle;
    
    @Column(name = "bi_detail")
    private String biDetail;
    
    @Column(name = "bi_reg_dt")
    private LocalDateTime biRegDt;
    
    @Column(name = "bi_edit_dt")
    private LocalDateTime biEditDt;
    
    @Column(name = "bi_views")
    private Integer biViews;
    
    @Column(name = "bi_status")
    private Integer biStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "bi_mi_seq")
    private MemberInfoEntity memberInfo;

    @OneToMany(mappedBy = "bimgBiSeq") // 이미지를 참조하여 이미지 리스트 형식으로 보여줌, 양방향 참조
    private List<BoardInfoEntity> imgs = new ArrayList<>(); // 참조되는 대상

    @OneToMany(mappedBy = "boardInfo") // 게시판을 참조하여 댓글 리스트 형식으로 보여줌, 양방향 참조
    private List<CommentInfoEntity> comment = new ArrayList<>(); // 참조되는 대상

    // 게시판 조회 수
    public void upView() {
        this.biViews = this.biViews+1;  // 누르면 조회수 1증가
    }
}
