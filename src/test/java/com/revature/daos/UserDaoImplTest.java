package com.revature.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {
	
	private UserDao ud;
	
    private SessionFactory mockSessionFactory;

    private Session mockSession;

    private Transaction mockTransaction;
 
    private User testUser;
    
	@Before
	public void setUp() {
		mockSessionFactory =  mock(SessionFactory.class);
		mockSession = mock(Session.class);
		mockTransaction = mock(Transaction.class);
	}
	
	@Test
	@Transactional(propagation=Propagation.SUPPORTS)
	public void testCreateUser() {
		testUser = new User(1, "test");
		when(mockSession.save(testUser)).thenReturn(1);
		int pk = (int) mockSession.save(testUser);
		mockTransaction.commit();
		assertEquals(1, pk);
	}
}
