package javabean;
import java.util.List;

public class pageResult<T> {

	private List<T> list;//����
	private int totalCount;//�ܼ�¼��
	private int  totalpage;//��ҳ��
	private int  currentPage;//��ǰҳ
	private int  pageCount=6;//ÿҳ��ʾ�� 
	
	public String toString() {
		return "pageResult [list= " +list+", totalCount=" + totalCount + ", totalpage=" + totalpage + ", currentPage="
				+ currentPage + ", pageCount=" + pageCount + "]";
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	

	
	
	
	
	}
