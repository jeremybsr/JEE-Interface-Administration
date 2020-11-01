package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IElementDao;
import fr.formation.model.Element;

@Repository
public class ElementJpaDao implements IElementDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Element> findAll() {
		return em.createQuery("select p from Element p", Element.class)
				.getResultList();
	}

	@Override
	public Element findById(int id) {
//		return em.createQuery("select p from Produit p where p.id = ?", Produit.class)
//				.setParameter(1, id)
//				.getSingleResult();
		
		return em.find(Element.class, id);
	}

	@Override
	@Transactional
	public Element save(Element entity) {
		if (entity.getId() == 0) { //AJOUT
			em.persist(entity);
		}
		
		else { //UPDATE
			entity = em.merge(entity);
		}
		
		return entity;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		em.createQuery("delete from Element p where p.id = ?")
			.setParameter(1, id)
			.executeUpdate();
		
//		em.remove(this.findById(id));
	}

	
	public List<Element> findByFournisseurId(int imageId) {
		return em.createQuery("select p from Element p where p.image.id = ?", Element.class)
				.setParameter(1, imageId)
				.getResultList();
	}

	/*@Override
	public List<Element> findByImageId(int image) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
