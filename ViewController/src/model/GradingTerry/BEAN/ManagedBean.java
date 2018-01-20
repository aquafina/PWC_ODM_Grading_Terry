package model.GradingTerry.BEAN;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class ManagedBean {
    public ManagedBean() {
    }

    /*****Generic Method to Get BindingContainer**/
    public BindingContainer getBindingsCont() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /**
     * Generic Method to execute operation
     * */
    public OperationBinding executeOperation(String operation) {
        OperationBinding createParam =
            getBindingsCont().getOperationBinding(operation);
        return createParam;

    }

    public void TotalQty_ValueChange(ValueChangeEvent valueChangeEvent) {
        // Calling Operation Binding with AM
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        // Customzied Method Name 
        OperationBinding operationBinding =
            executeOperation("Exceed_TOTALQTY");
        operationBinding.execute();
       // Ending Operation 
    }
}
