package sourcecode.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;

    private Integer totalPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalcount, Integer page, Integer size) {

        if(totalcount % size == 0){
            totalPage=totalcount/size;
        }else {
            totalPage=totalcount/size +1;
        }

        this.page = page;

        pages.add(page);
        for(int i=1;i<=3;i++){
            if(page-i>0){
                pages.add(0,page-i);
            }
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }

        //是否展示“上一页”
        if(page == 1){
            showPrevious = false;
        }else{
            showPrevious = true;
        }
        //是否展示“下一页”
        if(page == totalPage){
            showNext = false;
        }else {
            showNext = true;
        }
        //是否展示“第一页”
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        //是否展示“最后一页”
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }
    }
}
