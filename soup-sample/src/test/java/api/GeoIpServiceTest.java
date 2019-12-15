package api;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTest {
  @Test
  public void testMyIp() {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("208.104.51.176");
    assertEquals(ipLocation, "<GeoIP><Country>US</Country><State>SC</State></GeoIP>");
  }

  @Test
  public void testInvalidIp() {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("208.104.51.xxx");
    assertEquals(ipLocation, "<GeoIP><Country>US</Country><State>CA</State></GeoIP>");
  }
}
