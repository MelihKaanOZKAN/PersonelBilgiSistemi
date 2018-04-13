/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Casper
 */
public class Pagination {
    private int RowCount;
    private int pageIndex;
    private int rowLimit;
    private int pageCount;
    
    public int from(){
        return this.getPageIndex() * this.getRowLimit();
    }
    public int to(){
        return this.getRowLimit();
    }
    public void nextPage(){
        pageIndex++;
    }
    public void prevPage(){
        pageIndex--;
    }
    public boolean isPrevActive(){
        if(pageIndex != 0)
        {
            return true;
        }
        else{
            return false;
        }
    }
     public boolean isNextActive(){
        if(pageIndex < this.getPageCount()-1)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public int getRowCount() {
        return RowCount;
    }

    public int getPageCount() {
        pageCount = (int) Math.ceil( (double) RowCount / (double) rowLimit);
        return pageCount;
    }

    public void setRowCount(int RowCount) {
        this.RowCount = RowCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getRowLimit() {
        return rowLimit;
    }

    public void setRowLimit(int rowLimit) {
        this.rowLimit = rowLimit;
    }
    
    
    
}
