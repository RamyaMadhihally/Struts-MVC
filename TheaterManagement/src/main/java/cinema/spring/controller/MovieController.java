package cinema.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cinema.spring.config.Constants;
import cinema.spring.dao.DirectorDAO;
import cinema.spring.dao.LoginDAO;
import cinema.spring.dao.MovieDAO;
import cinema.spring.dao.ActorDAO;
import cinema.spring.dao.SearchDAO;
import cinema.spring.dao.ShowingDAO;
import cinema.spring.dao.UserPaymentDAO;
import cinema.spring.dao.WriterDAO;
import cinema.spring.model.Actor;
import cinema.spring.model.CustomMapper;
import cinema.spring.model.Director;
import cinema.spring.model.LoginException;
import cinema.spring.model.Movie;
import cinema.spring.model.Order;
import cinema.spring.model.SearchCriteria;
import cinema.spring.model.Showing;
import cinema.spring.model.Ticket;
import cinema.spring.model.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * handler methods. 
 *
 */
@Controller
public class MovieController {

	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private SearchDAO searchDAO;
	
	@Autowired
	private ShowingDAO showingDAO; 
	
	@Autowired
	private ActorDAO actorDAO;
	
	@Autowired
	private DirectorDAO directorDAO;
	
	@Autowired
	private WriterDAO writerDAO;
	
	@Autowired
	private UserPaymentDAO userPaymentDao;
		
	@Autowired
	private LoginDAO loginDAO;
	
			
	@RequestMapping(value="/movies")
	public ModelAndView listMovie(ModelAndView model) throws IOException{
		
		// to prevent access without logging in
		if(Constants.role.equals("") )
		{
			return new ModelAndView("PromptLogin");
		}
		
		List<Movie> listMovie = movieDAO.list();
		model.addObject("listMovie", listMovie);
		model.setViewName("Movie");		
		return model;
	}
	
	@RequestMapping(value = "/newMovie", method = RequestMethod.GET)
	public ModelAndView newMovie(ModelAndView model) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		Movie newMovie = new Movie();
		model.addObject("movie", newMovie);
		model.setViewName("MovieInfo");
		return model;
	}
	
	@RequestMapping(value = "/editMovie", method = RequestMethod.GET)
	public ModelAndView editMovie(HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int movieId = Integer.parseInt(request.getParameter("id"));
		Movie movie = movieDAO.get(movieId);
		ModelAndView model = new ModelAndView("MovieInfo");
		model.addObject("movie", movie);		
		return model;
	}
	
	@RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
	public ModelAndView saveMovie(@ModelAttribute Movie movie) {
		movieDAO.saveOrUpdate(movie);		
		return new ModelAndView("redirect:/movies");
	}
	
	@RequestMapping(value = "/deleteMovie", method = RequestMethod.GET)
	public ModelAndView deleteMovie(HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int movieId = Integer.parseInt(request.getParameter("id"));
		movieDAO.delete(movieId);
		return new ModelAndView("redirect:/movies");
	}
	
	@RequestMapping(value="/newSearchCriteria", method = RequestMethod.GET)
	public ModelAndView newSearchCriteria(ModelAndView model) throws IOException{
		SearchCriteria searchCriteria = new SearchCriteria();
		Movie movie = new Movie();
		Actor actor = new Actor();
		Director director = new Director();
		Writer writer = new Writer();
		searchCriteria.setMovie(movie);
		searchCriteria.setActor(actor);
		searchCriteria.setDirector(director);
		searchCriteria.setWriter(writer);
		model.addObject("searchCriteria", searchCriteria);
		model.setViewName("SearchCriteria");		
		return model;
	}
	
	@RequestMapping(value="/searchResult", method = RequestMethod.POST)
	public ModelAndView searchMovie(@ModelAttribute SearchCriteria searchCriteria, ModelAndView model) throws IOException{
		List<Movie> searchResult = searchDAO.list(searchCriteria);		
		model.addObject("searchResult", searchResult);
		model.setViewName("SearchResult");
		return model;
	}
	
	@RequestMapping(value="/listShowing")
	public ModelAndView listShowing(ModelAndView model) throws IOException{
		List<Showing> listShowing = showingDAO.list();
		model.addObject("listShowing", listShowing);
		model.setViewName("Showing");		
		return model;
	}
	
	@RequestMapping(value="/movieShowing")
	public ModelAndView movieShowing(ModelAndView model, HttpServletRequest request) throws IOException{
		int movieId = Integer.parseInt(request.getParameter("id"));	
		List<Showing> listShowing = showingDAO.listShowingsForMovie(movieId);
		model.addObject("listShowing", listShowing);
		model.setViewName("Showing");		
		return model;
	}
	
	@RequestMapping(value = "/newShowing", method = RequestMethod.GET)
	public ModelAndView addShowing(ModelAndView model) {	
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		Showing addShowing = new Showing();
		model.addObject("showing", addShowing);
		model.setViewName("ShowingInfo");
		return model;
	}
	
	@RequestMapping(value = "/saveShowing", method = RequestMethod.POST)
	public ModelAndView saveShowing(@ModelAttribute Showing showing) {
		showingDAO.saveOrUpdate(showing);		
		return new ModelAndView("redirect:/listShowing");
	}
	
	@RequestMapping(value = "/editShowing", method = RequestMethod.GET)
	public ModelAndView editShowing(HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int showId = Integer.parseInt(request.getParameter("showid"));
		Showing showing = showingDAO.get(showId);
		ModelAndView model = new ModelAndView("ShowingInfo");
		model.addObject("showing", showing);		
		return model;
	}
	
	@RequestMapping(value = "/deleteShowing", method = RequestMethod.GET)
	public ModelAndView deleteShowing(HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int showId = Integer.parseInt(request.getParameter("showid"));
		showingDAO.delete(showId);
		return new ModelAndView("redirect:/listShowing");
	}
	
	@RequestMapping(value="/bookShow", method = RequestMethod.GET)
	public ModelAndView listBooking(HttpServletRequest request) {
		int showId = Integer.parseInt(request.getParameter("showid"));
		Showing show = showingDAO.get(showId);
		Movie movie = movieDAO.get(show.getMovieId());		
		ModelAndView model = new ModelAndView("BookShow");
		model.addObject("show", show);		
		model.addObject("movie", movie);		
		Order order = new Order();
		model.addObject("order", order);		
		return model;
	}
	
	@RequestMapping(value = "/purchaseOrder", method = RequestMethod.POST)
	public ModelAndView purchaseOrder(@ModelAttribute Order order, ModelAndView model, HttpServletRequest request) {
		int quantity = order.getQuantity();	
		String paymentMethod = order.getPaymentMethod();
		int showId = Integer.parseInt(request.getParameter("showid"));	
		Showing show = showingDAO.get(showId);	
		model.addObject("totalPrice",show.getprice() * quantity);
		model.addObject("paymentMethod",paymentMethod);		
		model.addObject("show",show);
		
		List <Ticket> tickets = new ArrayList<Ticket>();
		for(int i=0; i < quantity; i++)
		{
			Ticket ticket = new Ticket();
			
			int userPaymentRegistrationId = userPaymentDao.getUserPaymentRegistrationId(Constants.user, paymentMethod);			
			ticket.setPaymentRegistratonId(userPaymentRegistrationId);			
			
			ticket.setRoomNumber(show.getroomNumber());
			ticket.setStartTime(show.getstartTime());		
			tickets.add(ticket);
		}
		String confirmationNumber = showingDAO.bookTickets(tickets);
		model.addObject("confirmationNumber",confirmationNumber);	
		model.setViewName("Confirmation");
		return model;
	}	
	
	@RequestMapping(value="/cast")
	public ModelAndView cast(ModelAndView model,  HttpServletRequest request) throws IOException{
		int movieId = Integer.parseInt(request.getParameter("id"));
		List<Actor> listActors = movieDAO.listActors(movieId);
		List<Director> listDirectors = movieDAO.listDirectors(movieId);
		List<Writer> listWriters=movieDAO.listWriters(movieId);
		model.addObject("movieId", movieId);
		model.addObject("movieTitle",movieDAO.get(movieId).getTitle());
		model.addObject("listActors", listActors);
		model.addObject("listDirectors", listDirectors);
		model.addObject("listWriters", listWriters);
		model.setViewName("Cast");		
		return model;
	}
	
	@RequestMapping(value = "/addActorInfo", method = RequestMethod.GET)
	public ModelAndView addActorInfo(ModelAndView model, HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int movieId = Integer.parseInt(request.getParameter("id"));
		Actor actor = new Actor();
		actor.setMovieid(movieId);
		model.addObject("actor", actor);
		model.setViewName("ActorInfo");
		return model;
	}

	@RequestMapping(value = "/saveActor", method = RequestMethod.POST)
	public ModelAndView saveActor(@ModelAttribute Actor actor, HttpServletRequest request) {
		actorDAO.saveOrUpdate(actor);
		int movieId = Integer.parseInt(request.getParameter("movieid"));
		return new ModelAndView("redirect:/cast?id="+movieId);
	}
	
	@RequestMapping(value = "/deleteActor", method = RequestMethod.GET)
	public ModelAndView deleteActor(HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int actorId = Integer.parseInt(request.getParameter("id"));
		int movieId = Integer.parseInt(request.getParameter("movieid"));
		actorDAO.delete(actorId, movieId);
		return new ModelAndView("redirect:/cast?id="+movieId);
	}

	@RequestMapping(value = "/addWriterInfo", method = RequestMethod.GET)
	public ModelAndView addWriterInfo(ModelAndView model, HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		int movieId = Integer.parseInt(request.getParameter("id"));
		Writer writer = new Writer();
		writer.setMovieid(movieId);
		model.addObject("writer", writer);
		model.setViewName("WriterInfo");
		return model;
	}

	@RequestMapping(value = "/saveWriter", method = RequestMethod.POST)
	public ModelAndView saveWriter(@ModelAttribute Writer writer, HttpServletRequest request) {
	 writerDAO.saveOrUpdate(writer);		
		int movieId = Integer.parseInt(request.getParameter("movieid"));
		return new ModelAndView("redirect:/cast?id="+movieId);
	}
	
	@RequestMapping(value = "/deleteWriter", method = RequestMethod.GET)
	public ModelAndView deleteWriter(HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int writerId = Integer.parseInt(request.getParameter("id"));
		int movieId = Integer.parseInt(request.getParameter("movieid"));
		writerDAO.delete(writerId, movieId);
		return new ModelAndView("redirect:/cast?id="+movieId);
	}
	
	@RequestMapping(value = "/addDirectorInfo", method = RequestMethod.GET)
	public ModelAndView addDirectorInfo(ModelAndView model, HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int movieId = Integer.parseInt(request.getParameter("id"));
		Director director = new Director();
		director.setMovieid(movieId);
		model.addObject("director", director);
		model.setViewName("DirectorInfo");
		return model;
	}

	@RequestMapping(value = "/saveDirector", method = RequestMethod.POST)
	public ModelAndView saveDirector(@ModelAttribute Director director, HttpServletRequest request) {
	 directorDAO.saveOrUpdate(director);	
	 int movieId = Integer.parseInt(request.getParameter("movieid"));
	 return new ModelAndView("redirect:/cast?id="+movieId);
	}
	
	@RequestMapping(value = "/deleteDirector", method = RequestMethod.GET)
	public ModelAndView deleteDirector(HttpServletRequest request) {
		
		// only staff is authorized for this operation
		if(Constants.role.equals(Constants.ROLE_MEMBER))
		{
			return new ModelAndView("Unauthorized");
		}
		
		int directorId = Integer.parseInt(request.getParameter("id"));
		int movieId = Integer.parseInt(request.getParameter("movieid"));
		directorDAO.delete(directorId, movieId);
		return new ModelAndView("redirect:/cast?id="+movieId);
	}
	
	// Login
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewLogin(Map<String, Object> model){
		Constants.role = "";
		CustomMapper loginForm=new CustomMapper();
		model.put("loginForm", loginForm);
		return "Login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
		public ModelAndView validateUser(@ModelAttribute("loginForm")CustomMapper login, ModelAndView model) throws Exception {
		login =loginDAO.validateUser(login.getUserName(),login.getPassword());
		model.addObject("login", login);
		model.addObject("username", login.getUserName());
		model.addObject("role", login.getRole());
		List<Movie> listMovie = movieDAO.list();
		model.addObject("listMovie", listMovie);
		model.setViewName("Movie");		
		return model;		
	}
	
	@ExceptionHandler({LoginException.class})
	public ModelAndView handleLoginException(LoginException ex){
		ModelAndView model = new ModelAndView("LoginException");
		model.addObject("ex", ex);
		return model;
	}
	
	@ExceptionHandler({Exception.class})
	public ModelAndView handleException(Exception ex){
		ModelAndView model = new ModelAndView("Exception");
		model.addObject("ex", ex);
		return model;	 
	}
}
