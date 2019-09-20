package com.ef;

import com.ef.entities.Comment;
import com.ef.repositories.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CommentRepository repository;


	@Test
	public void testFindByIp() {
		entityManager.persist(new Comment("192.168.113.80","more requested than allowed"));
		List<Comment> comment = repository.findByIp("192.168.113.80");
		assertEquals(1, comment.size());
	}

	@Test
	public void testAssertThatEqual() {
		entityManager.persist(new Comment("192.168.113.81","more requested than allowed"));
		List<Comment> comment = repository.findByIp("192.168.113.81");
		assertThat(comment.get(0).getIp(),is("192.168.113.81"));
	}


}
