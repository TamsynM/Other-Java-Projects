package budgetapp2;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-03T15:40:17")
@StaticMetamodel(Expenditure.class)
public class Expenditure_ { 

    public static volatile SingularAttribute<Expenditure, Integer> expAmount;
    public static volatile SingularAttribute<Expenditure, Integer> id;
    public static volatile SingularAttribute<Expenditure, String> expCategory;
    public static volatile SingularAttribute<Expenditure, Date> expDate;

}