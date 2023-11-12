package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.SearchPageObject;

public class ChangeAppConditionTests extends CoreTestCase
{
 @Test
 public void testChangeScreenOrientionOnSearchResults()
 {
  SearchPageObject SearchPageObject = new SearchPageObject(driver);
  SearchPageObject.initSearchInput();
  SearchPageObject.typeSearchLine("Java");
  SearchPageObject.waitForSearchResult("Object-oriented programming language");

  ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
  String article_title = ArticlePageObject.getArticleTitle();
  this.rotateScreenLandscape();
  String title_after_rotation = ArticlePageObject.getArticleTitle();

  assertEquals(
          "Article title have been changed screen rotation",
          title_before_rotation,
          title_after_rotation
  );
  this.rotateScreenPortrait();
  String title_after_second_rotation = ArticlePageObject.getArticleTitle();

  assertEquals(
          "Article title have been changed screen rotation",
          title_before_rotation,
          title_after_second_rotation
  );
  }

}




