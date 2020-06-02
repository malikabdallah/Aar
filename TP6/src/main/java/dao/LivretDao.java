package dao;

import modele.Livret;

public interface LivretDao extends AbstractDao<Livret> {


}


/*package dao;

import modele.Livret;

public class AbstractDaoImpl extends AbstractDaoImpl<Livret> implements LivretDao {
    public AbstractDaoImpl(){this(Livret.class);}
    public AbstractDaoImpl(class<Livret> entityClass){super(entityClass);}




}
*/