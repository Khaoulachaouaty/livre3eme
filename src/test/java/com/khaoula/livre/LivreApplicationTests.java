package com.khaoula.livre;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.khaoula.livre.entities.Editeur;
import com.khaoula.livre.entities.Livre;
import com.khaoula.livre.repos.LivreRepository;
@SpringBootTest
class LivreApplicationTests {
@Autowired
private LivreRepository livreRepository;
@Test
public void testCreateLivre() {
Livre lvre = new Livre("PC Dell",2200.500,new Date());
livreRepository.save(lvre);
}

//rouge
@Test
public void testFindLivre()
{
	Livre l = livreRepository.findById(2L).get();
	System.out.println(l);
}

//rouge
@Test
public void testUpdateLivre()
{
	Livre l = livreRepository.findById(1L).get();
	l.setPrixLivre(1000.0);
	livreRepository.save(l);
}

//rouge
@Test
public void testDeleteLivre()
{
	livreRepository.deleteById(1L);;
}

//rouge
@Test
public void testListerTousLivre()
{
	List<Livre> lvres = livreRepository.findAll();
	for (Livre l : lvres)
	{
	System.out.println(l);
	}
}
@Test
public void testFindByNomLivre()
{
	List<Livre> lvres = livreRepository.findByNomLivre("iphone X");
	for (Livre l : lvres)
	{
		System.out.println(l);
	}
}
@Test
public void testFindByNomLivreContains ()
{
List<Livre> lvres=livreRepository.findByNomLivreContains("iphone");
	for (Livre l : lvres)
	{
	System.out.println(l);
	}
}
@Test
public void testfindByNomPrix()
{
	List<Livre> lvres = livreRepository.findByNomPrix("iphone X", 1000.0);
	for (Livre l : lvres)
	{
	System.out.println(l);
	}
}

//rouge
@Test
public void testfindByEditeur()
{
	Editeur ed = new Editeur();
	ed.setIdEd(1L);
	List<Livre> lvres = livreRepository.findByEditeur(ed);
	for (Livre l : lvres)
	{
	System.out.println(l);
}
}

//rouge
@Test
public void findByEditeurIdEd()
{
	List<Livre> lvres = livreRepository.findByEditeurIdEd(1L);
	for (Livre l : lvres)
	{
	System.out.println(l);
	}
}

//rouge
@Test
public void testfindByOrderByNomLivreAsc()
{
	List<Livre> lvres =
	livreRepository.findByOrderByNomLivreAsc();
	for (Livre l : lvres)
	{
	System.out.println(l);
	}
}

//rouge
@Test
public void testTrierLivreNomsPrix()
{
	List<Livre> lvres = livreRepository.trierLivreNomsPrix();
	for (Livre l : lvres)
	{
	System.out.println(l);
	}
}

}