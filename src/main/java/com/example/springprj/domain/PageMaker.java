package com.example.springprj.domain;

public class PageMaker {
    public int getTotalCount() {
        return totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public Criteria getCri() {
        return cri;
    }

    private int totalCount; //전체 게시글 개수
    private int startPage; //시작페이지 번호
    private int endPage; // 끝페이지 번호
    private boolean prev; //이전
    private boolean next; //다음
    private int displayPageNum = 10;

    private Criteria cri;

    public void setCriteria(Criteria cri) {
        this.cri = cri;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() {


        endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum); //끝페이지 = (현재 페이지번호/ 하단페이지번호 개수) * 하단페이지번호 개수

        startPage = (endPage - displayPageNum) + 1; //시작페이지번호 = 끝페이지 - 하단페이지번호개수 -1

        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum())); //임시 끝페이지

        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;
        next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
    }

    @Override
    public String toString() {
        return "PageMaker{" +
                "totalCount=" + totalCount +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", displayPageNum=" + displayPageNum +
                ", cri=" + cri +
                '}';
    }
}
