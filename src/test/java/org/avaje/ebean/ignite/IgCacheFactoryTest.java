package org.avaje.ebean.ignite;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.cache.ServerCache;
import com.avaje.ebean.cache.ServerCacheManager;
import main.Server;
import org.example.domain.EFoo;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class IgCacheFactoryTest {

  private final EbeanServer server;

  Server igniteServer;

  public IgCacheFactoryTest() {
    igniteServer = new Server();
    server = Ebean.getDefaultServer();
  }

  @Test
  public void integration() {


    ServerCacheManager cacheManager = server.getServerCacheManager();
    ServerCache beanCache = cacheManager.getBeanCache(EFoo.class);

    assertThat(beanCache).isInstanceOf(IgCache.class);

    EFoo fetch1 = Ebean.find(EFoo.class, 1);

    System.out.println("f" + fetch1);
  }

  @Test(dependsOnMethods = "integration")
  public void putGet() throws InterruptedException {

    EFoo foo = new EFoo("hello");
    foo.save();

    EFoo fetch1 = Ebean.find(EFoo.class)
        .setId(foo.getId())
        .select("name, status, notes, version")
        .findUnique();

    EFoo fetch2 = Ebean.find(EFoo.class)
        .setId(foo.getId())
        .select("name, status, notes, version")
        .findUnique();

    assertNotNull(fetch1);
    assertNotNull(fetch2);

    EFoo update = new EFoo();
    update.setId(foo.getId());
    update.setNotes("ModNotes");
    update.update();

    Thread.sleep(20);

    EFoo fetch3 = Ebean.find(EFoo.class)
        .setId(foo.getId())
        .select("name, status, notes, version")
        .findUnique();

    assertNotNull(fetch3);
    assertEquals(fetch3.getNotes(), "ModNotes");
    assertEquals(fetch3.getName(), "hello");

  }
}