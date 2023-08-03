import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;
import java.util.Currency;

public class C206_CaseStudyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before C206_CaseStudyTest class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
	}

	@Test
	public void enterFeedback() {
//		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

	}

	@Test
	public void viewFeedback() {
//		assertEquals(,C206_CaseStudy.ViewFeedback());
//		assertEquals(null,C206_CaseStudy.ViewFeedback(-12,-1,-3,-4,-2})
	}
	public void EnterFeedback() {
		ArrayList<Feedback> FeedbackArrayList = new ArrayList<Feedback>();
		System.out.println("start test case addCurrency");
		System.out.println("test case addCurrency with assertEquals");
		assertEquals(1,C206_CaseStudy.EnterFeedback(FeedbackArrayList,"123"));
		assertNotEquals(0,C206_CaseStudy.EnterFeedback(FeedbackArrayList,"okok"));
	}

	


	
	@After
	public void tearDown() throws Exception {
		System.out.println("afters");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after C206_CaseStudyTest class");
	}

}
