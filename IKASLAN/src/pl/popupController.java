package pl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Murad R. Imanbayli <muradimanbayli at gmail.com>
 */
@ManagedBean
@SessionScoped
public class popupController implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean showPopup;
    
    public void show(){
        showPopup=true;
    }
    public void hide(){
        showPopup=false;
    }

    public boolean isShowPopup() {
        return showPopup;
    }

    public void setShowPopup(boolean showPopup) {
        this.showPopup = showPopup;
    }
    
    
}