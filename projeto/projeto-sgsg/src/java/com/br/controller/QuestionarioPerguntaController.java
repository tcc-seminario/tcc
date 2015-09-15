package com.br.controller;

import com.br.entity.QuestionarioPergunta;
import com.br.controller.util.JsfUtil;
import com.br.controller.util.PaginationHelper;
import com.br.dao.QuestionarioPerguntaFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "questionarioPerguntaController")
@SessionScoped
public class QuestionarioPerguntaController implements Serializable {

    private QuestionarioPergunta current;
    private DataModel items = null;
    @EJB
    private com.br.dao.QuestionarioPerguntaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public QuestionarioPerguntaController() {
    }

    public QuestionarioPergunta getSelected() {
        if (current == null) {
            current = new QuestionarioPergunta();
            current.setQuestionarioPerguntaPK(new com.br.entity.QuestionarioPerguntaPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private QuestionarioPerguntaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (QuestionarioPergunta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new QuestionarioPergunta();
        current.setQuestionarioPerguntaPK(new com.br.entity.QuestionarioPerguntaPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getQuestionarioPerguntaPK().setQuestionarioIdQuestionario(current.getQuestionario().getIdQuestionario());
            current.getQuestionarioPerguntaPK().setPerguntaIdPergunta(current.getPergunta().getIdPergunta());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("QuestionarioPerguntaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (QuestionarioPergunta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getQuestionarioPerguntaPK().setQuestionarioIdQuestionario(current.getQuestionario().getIdQuestionario());
            current.getQuestionarioPerguntaPK().setPerguntaIdPergunta(current.getPergunta().getIdPergunta());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("QuestionarioPerguntaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (QuestionarioPergunta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("QuestionarioPerguntaDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = QuestionarioPergunta.class)
    public static class QuestionarioPerguntaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            QuestionarioPerguntaController controller = (QuestionarioPerguntaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "questionarioPerguntaController");
            return controller.ejbFacade.find(getKey(value));
        }

        com.br.entity.QuestionarioPerguntaPK getKey(String value) {
            com.br.entity.QuestionarioPerguntaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.br.entity.QuestionarioPerguntaPK();
            key.setId(Integer.parseInt(values[0]));
            key.setQuestionarioIdQuestionario(Integer.parseInt(values[1]));
            key.setPerguntaIdPergunta(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(com.br.entity.QuestionarioPerguntaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getId());
            sb.append(SEPARATOR);
            sb.append(value.getQuestionarioIdQuestionario());
            sb.append(SEPARATOR);
            sb.append(value.getPerguntaIdPergunta());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof QuestionarioPergunta) {
                QuestionarioPergunta o = (QuestionarioPergunta) object;
                return getStringKey(o.getQuestionarioPerguntaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + QuestionarioPergunta.class.getName());
            }
        }

    }

}
