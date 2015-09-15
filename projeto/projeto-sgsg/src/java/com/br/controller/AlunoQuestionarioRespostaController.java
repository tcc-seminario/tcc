package com.br.controller;

import com.br.entity.AlunoQuestionarioResposta;
import com.br.controller.util.JsfUtil;
import com.br.controller.util.PaginationHelper;
import com.br.dao.AlunoQuestionarioRespostaFacade;

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

@ManagedBean(name = "alunoQuestionarioRespostaController")
@SessionScoped
public class AlunoQuestionarioRespostaController implements Serializable {

    private AlunoQuestionarioResposta current;
    private DataModel items = null;
    @EJB
    private com.br.dao.AlunoQuestionarioRespostaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public AlunoQuestionarioRespostaController() {
    }

    public AlunoQuestionarioResposta getSelected() {
        if (current == null) {
            current = new AlunoQuestionarioResposta();
            current.setAlunoQuestionarioRespostaPK(new com.br.entity.AlunoQuestionarioRespostaPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private AlunoQuestionarioRespostaFacade getFacade() {
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
        current = (AlunoQuestionarioResposta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new AlunoQuestionarioResposta();
        current.setAlunoQuestionarioRespostaPK(new com.br.entity.AlunoQuestionarioRespostaPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getAlunoQuestionarioRespostaPK().setAlunoQuestionarioAlunoIdAluno(current.getAlunoQuestionario().getAlunoQuestionarioPK().getAlunoIdAluno());
            current.getAlunoQuestionarioRespostaPK().setAlunoQuestionarioQuestionarioIdQuestionario(current.getAlunoQuestionario().getAlunoQuestionarioPK().getQuestionarioIdQuestionario());
            current.getAlunoQuestionarioRespostaPK().setRespostaIdResposta(current.getResposta().getIdResposta());
            current.getAlunoQuestionarioRespostaPK().setAlunoQuestionarioId(current.getAlunoQuestionario().getAlunoQuestionarioPK().getId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AlunoQuestionarioRespostaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (AlunoQuestionarioResposta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getAlunoQuestionarioRespostaPK().setAlunoQuestionarioAlunoIdAluno(current.getAlunoQuestionario().getAlunoQuestionarioPK().getAlunoIdAluno());
            current.getAlunoQuestionarioRespostaPK().setAlunoQuestionarioQuestionarioIdQuestionario(current.getAlunoQuestionario().getAlunoQuestionarioPK().getQuestionarioIdQuestionario());
            current.getAlunoQuestionarioRespostaPK().setRespostaIdResposta(current.getResposta().getIdResposta());
            current.getAlunoQuestionarioRespostaPK().setAlunoQuestionarioId(current.getAlunoQuestionario().getAlunoQuestionarioPK().getId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AlunoQuestionarioRespostaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (AlunoQuestionarioResposta) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AlunoQuestionarioRespostaDeleted"));
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

    @FacesConverter(forClass = AlunoQuestionarioResposta.class)
    public static class AlunoQuestionarioRespostaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AlunoQuestionarioRespostaController controller = (AlunoQuestionarioRespostaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "alunoQuestionarioRespostaController");
            return controller.ejbFacade.find(getKey(value));
        }

        com.br.entity.AlunoQuestionarioRespostaPK getKey(String value) {
            com.br.entity.AlunoQuestionarioRespostaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.br.entity.AlunoQuestionarioRespostaPK();
            key.setId(values[0]);
            key.setAlunoQuestionarioId(Integer.parseInt(values[1]));
            key.setAlunoQuestionarioAlunoIdAluno(Integer.parseInt(values[2]));
            key.setAlunoQuestionarioQuestionarioIdQuestionario(Integer.parseInt(values[3]));
            key.setRespostaIdResposta(Integer.parseInt(values[4]));
            return key;
        }

        String getStringKey(com.br.entity.AlunoQuestionarioRespostaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getId());
            sb.append(SEPARATOR);
            sb.append(value.getAlunoQuestionarioId());
            sb.append(SEPARATOR);
            sb.append(value.getAlunoQuestionarioAlunoIdAluno());
            sb.append(SEPARATOR);
            sb.append(value.getAlunoQuestionarioQuestionarioIdQuestionario());
            sb.append(SEPARATOR);
            sb.append(value.getRespostaIdResposta());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AlunoQuestionarioResposta) {
                AlunoQuestionarioResposta o = (AlunoQuestionarioResposta) object;
                return getStringKey(o.getAlunoQuestionarioRespostaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + AlunoQuestionarioResposta.class.getName());
            }
        }

    }

}
