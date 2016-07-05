import edu.iis.mto.time.Order;
import edu.iis.mto.time.OrderExpiredException;
import org.joda.time.DateTimeUtils;
import org.joda.time.Duration;
import org.junit.Test;

/**
 * Created by pawelek on 06.07.16.
 */
public class TestOrder {


    private long invalidDate = DateTimeUtils.currentTimeMillis() + Duration.standardDays(1).getMillis()*2;

    @Test(expected = OrderExpiredException.class)
    public void TestConfirmMethodShouldThrowOrderExpiredException() {
        DateTimeUtils.setCurrentMillisFixed(System.currentTimeMillis());
        Order order = new Order();


        order.submit();

        DateTimeUtils.setCurrentMillisFixed(invalidDate);

        order.confirm();
    }
}
