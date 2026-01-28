package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     *
     * @param aTitle
     * @param aDescription
     * @param enterprise
     * @return
     */
    public Project newProject(String aTitle, String aDescription, Enterprise enterprise) {
        Project project = new Project();
        project.setTitle(aTitle);
        project.setDescription(aDescription);
        project.setEnterprise(enterprise);

        entityManager.persist(project);
        entityManager.flush();

        enterprise.addProject(project);

        return project;
    }

    /**
     *
     * @param aName
     * @param aDescription
     * @param aContactName
     * @param aMail
     * @return and enterprise
     */
    public Enterprise newEnterprise(String aName, String aDescription, String aContactName, String aMail) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(aName);
        enterprise.setDescription(aDescription);
        enterprise.setContactName(aContactName);
        enterprise.setContactEmail(aMail);

        entityManager.persist(enterprise);
        entityManager.flush();

        return enterprise;
    }

    /**
     *
     * @param id
     * @return a project
     */
    public Project findProjectById(Long id) {
        return entityManager.find(Project.class, id);
    }

    /**
     *
     * @param id
     * @return an enterprise
     */
    public Enterprise findEnterpriseById(Long id) {
        return entityManager.find(Enterprise.class, id);
    }
}
