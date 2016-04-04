import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class TestMyServlet {

    @Test
    public void testServlet() throws Exception {

        BufferedReader tempReader = new BufferedReader(new StringReader("{\n" +
                "    \"ok\": true,\n" +
                "    \"result\": [\n" +
                "        {\n" +
                "            \"update_id\": 334908714,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 14,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 208288542,\n" +
                "                    \"first_name\": \"Tobias N.\",\n" +
                "                    \"last_name\": \"\uD83C\uDDE9\uD83C\uDDF0\",\n" +
                "                    \"username\": \"Abeneezer\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": 208288542,\n" +
                "                    \"first_name\": \"Tobias N.\",\n" +
                "                    \"last_name\": \"\uD83C\uDDE9\uD83C\uDDF0\",\n" +
                "                    \"username\": \"Abeneezer\",\n" +
                "                    \"type\": \"private\"\n" +
                "                },\n" +
                "                \"date\": 1459553110,\n" +
                "                \"text\": \"sdfasdf\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908715,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44043,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 208288542,\n" +
                "                    \"first_name\": \"Tobias N.\",\n" +
                "                    \"last_name\": \"\uD83C\uDDE9\uD83C\uDDF0\",\n" +
                "                    \"username\": \"Abeneezer\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553164,\n" +
                "                \"new_chat_participant\": {\n" +
                "                    \"id\": 186488178,\n" +
                "                    \"first_name\": \"AbeneezerBot\",\n" +
                "                    \"username\": \"AbeneezerBot\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908716,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44044,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 101566181,\n" +
                "                    \"first_name\": \"Притченко\",\n" +
                "                    \"username\": \"Pritchenko\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553175,\n" +
                "                \"document\": {\n" +
                "                    \"file_name\": \"o287DB.gif.mp4\",\n" +
                "                    \"mime_type\": \"video/mp4\",\n" +
                "                    \"thumb\": {\n" +
                "                        \"file_id\": \"AAQEABNsTCYZAATBRDPl2KBJYcR9AAIC\",\n" +
                "                        \"file_size\": 2142,\n" +
                "                        \"width\": 90,\n" +
                "                        \"height\": 67\n" +
                "                    },\n" +
                "                    \"file_id\": \"BQADBAAD-QgAAs0eZAdsrc6KvgMfFAI\",\n" +
                "                    \"file_size\": 350947\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908717,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44045,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 208288542,\n" +
                "                    \"first_name\": \"Tobias N.\",\n" +
                "                    \"last_name\": \"\uD83C\uDDE9\uD83C\uDDF0\",\n" +
                "                    \"username\": \"Abeneezer\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553207,\n" +
                "                \"text\": \":D\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908718,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44046,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 26927785,\n" +
                "                    \"first_name\": \"Robin\",\n" +
                "                    \"last_name\": \"van der Vliet\",\n" +
                "                    \"username\": \"Robin\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553222,\n" +
                "                \"text\": \"mi devus dormi baldaŭ \uD83D\uDE06\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908719,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44047,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 26927785,\n" +
                "                    \"first_name\": \"Robin\",\n" +
                "                    \"last_name\": \"van der Vliet\",\n" +
                "                    \"username\": \"Robin\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553228,\n" +
                "                \"text\": \"eĜtas jam sufiĉe malfrue nun \uD83D\uDE06\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908720,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44048,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 128928567,\n" +
                "                    \"first_name\": \"Rafael Bezerra\",\n" +
                "                    \"last_name\": \"do Ó\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553258,\n" +
                "                \"text\": \"Hahahhh\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908721,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44049,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 208288542,\n" +
                "                    \"first_name\": \"Tobias N.\",\n" +
                "                    \"last_name\": \"\uD83C\uDDE9\uD83C\uDDF0\",\n" +
                "                    \"username\": \"Abeneezer\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553323,\n" +
                "                \"text\": \"Mi ankaŭ\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908722,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44050,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 208288542,\n" +
                "                    \"first_name\": \"Tobias N.\",\n" +
                "                    \"last_name\": \"\uD83C\uDDE9\uD83C\uDDF0\",\n" +
                "                    \"username\": \"Abeneezer\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553328,\n" +
                "                \"text\": \"sed... ne\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908723,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44051,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 26927785,\n" +
                "                    \"first_name\": \"Robin\",\n" +
                "                    \"last_name\": \"van der Vliet\",\n" +
                "                    \"username\": \"Robin\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553335,\n" +
                "                \"reply_to_message\": {\n" +
                "                    \"message_id\": 44050,\n" +
                "                    \"from\": {\n" +
                "                        \"id\": 208288542,\n" +
                "                        \"first_name\": \"Tobias N.\",\n" +
                "                        \"last_name\": \"\uD83C\uDDE9\uD83C\uDDF0\",\n" +
                "                        \"username\": \"Abeneezer\"\n" +
                "                    },\n" +
                "                    \"chat\": {\n" +
                "                        \"id\": -1001004513570,\n" +
                "                        \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                        \"type\": \"supergroup\"\n" +
                "                    },\n" +
                "                    \"date\": 1459553328,\n" +
                "                    \"text\": \"sed... ne\"\n" +
                "                },\n" +
                "                \"text\": \"jes, hahahaha \uD83D\uDE06\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908724,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44052,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 128928567,\n" +
                "                    \"first_name\": \"Rafael Bezerra\",\n" +
                "                    \"last_name\": \"do Ó\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553337,\n" +
                "                \"text\": \"Tiu apro estas freneza\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908725,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44053,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 208288542,\n" +
                "                    \"first_name\": \"Tobias N.\",\n" +
                "                    \"last_name\": \"\uD83C\uDDE9\uD83C\uDDF0\",\n" +
                "                    \"username\": \"Abeneezer\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553527,\n" +
                "                \"text\": \"Tia besto nomas 'apro'?\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908726,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44054,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 128928567,\n" +
                "                    \"first_name\": \"Rafael Bezerra\",\n" +
                "                    \"last_name\": \"do Ó\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553967,\n" +
                "                \"text\": \"Jes\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"update_id\": 334908727,\n" +
                "            \"message\": {\n" +
                "                \"message_id\": 44055,\n" +
                "                \"from\": {\n" +
                "                    \"id\": 128928567,\n" +
                "                    \"first_name\": \"Rafael Bezerra\",\n" +
                "                    \"last_name\": \"do Ó\"\n" +
                "                },\n" +
                "                \"chat\": {\n" +
                "                    \"id\": -1001004513570,\n" +
                "                    \"title\": \"Esperantujo \uD83C\uDF40\",\n" +
                "                    \"type\": \"supergroup\"\n" +
                "                },\n" +
                "                \"date\": 1459553981,\n" +
                "                \"text\": \"Laŭ la vortaroĝŝĵĥ\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}"));
        HttpServletRequest request = new HttpServletRequest() {
            @Override
            public String getAuthType() {
                return null;
            }

            @Override
            public Cookie[] getCookies() {
                return new Cookie[0];
            }

            @Override
            public long getDateHeader(String s) {
                return 0;
            }

            @Override
            public String getHeader(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getHeaders(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getHeaderNames() {
                return null;
            }

            @Override
            public int getIntHeader(String s) {
                return 0;
            }

            @Override
            public String getMethod() {
                return null;
            }

            @Override
            public String getPathInfo() {
                return null;
            }

            @Override
            public String getPathTranslated() {
                return null;
            }

            @Override
            public String getContextPath() {
                return null;
            }

            @Override
            public String getQueryString() {
                return null;
            }

            @Override
            public String getRemoteUser() {
                return null;
            }

            @Override
            public boolean isUserInRole(String s) {
                return false;
            }

            @Override
            public Principal getUserPrincipal() {
                return null;
            }

            @Override
            public String getRequestedSessionId() {
                return null;
            }

            @Override
            public String getRequestURI() {
                return null;
            }

            @Override
            public StringBuffer getRequestURL() {
                return null;
            }

            @Override
            public String getServletPath() {
                return null;
            }

            @Override
            public HttpSession getSession(boolean b) {
                return null;
            }

            @Override
            public HttpSession getSession() {
                return null;
            }

            @Override
            public String changeSessionId() {
                return null;
            }

            @Override
            public boolean isRequestedSessionIdValid() {
                return false;
            }

            @Override
            public boolean isRequestedSessionIdFromCookie() {
                return false;
            }

            @Override
            public boolean isRequestedSessionIdFromURL() {
                return false;
            }

            @Override
            public boolean isRequestedSessionIdFromUrl() {
                return false;
            }

            @Override
            public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
                return false;
            }

            @Override
            public void login(String s, String s1) throws ServletException {

            }

            @Override
            public void logout() throws ServletException {

            }

            @Override
            public Collection<Part> getParts() throws IOException, ServletException {
                return null;
            }

            @Override
            public Part getPart(String s) throws IOException, ServletException {
                return null;
            }

            @Override
            public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
                return null;
            }

            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                return null;
            }

            @Override
            public String getCharacterEncoding() {
                return null;
            }

            @Override
            public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

            }

            @Override
            public int getContentLength() {
                return 0;
            }

            @Override
            public long getContentLengthLong() {
                return 0;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public ServletInputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public String getParameter(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getParameterNames() {
                return null;
            }

            @Override
            public String[] getParameterValues(String s) {
                return new String[0];
            }

            @Override
            public Map<String, String[]> getParameterMap() {
                return null;
            }

            @Override
            public String getProtocol() {
                return null;
            }

            @Override
            public String getScheme() {
                return null;
            }

            @Override
            public String getServerName() {
                return null;
            }

            @Override
            public int getServerPort() {
                return 0;
            }

            @Override
            public BufferedReader getReader() throws IOException {
                return tempReader;
            }

            @Override
            public String getRemoteAddr() {
                return null;
            }

            @Override
            public String getRemoteHost() {
                return null;
            }

            @Override
            public void setAttribute(String s, Object o) {

            }

            @Override
            public void removeAttribute(String s) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }

            @Override
            public Enumeration<Locale> getLocales() {
                return null;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public RequestDispatcher getRequestDispatcher(String s) {
                return null;
            }

            @Override
            public String getRealPath(String s) {
                return null;
            }

            @Override
            public int getRemotePort() {
                return 0;
            }

            @Override
            public String getLocalName() {
                return null;
            }

            @Override
            public String getLocalAddr() {
                return null;
            }

            @Override
            public int getLocalPort() {
                return 0;
            }

            @Override
            public ServletContext getServletContext() {
                return null;
            }

            @Override
            public AsyncContext startAsync() throws IllegalStateException {
                return null;
            }

            @Override
            public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
                return null;
            }

            @Override
            public boolean isAsyncStarted() {
                return false;
            }

            @Override
            public boolean isAsyncSupported() {
                return false;
            }

            @Override
            public AsyncContext getAsyncContext() {
                return null;
            }

            @Override
            public DispatcherType getDispatcherType() {
                return null;
            }
        };
        HttpServletResponse response = new HttpServletResponse() {
            @Override
            public void addCookie(Cookie cookie) {

            }

            @Override
            public boolean containsHeader(String s) {
                return false;
            }

            @Override
            public String encodeURL(String s) {
                return null;
            }

            @Override
            public String encodeRedirectURL(String s) {
                return null;
            }

            @Override
            public String encodeUrl(String s) {
                return null;
            }

            @Override
            public String encodeRedirectUrl(String s) {
                return null;
            }

            @Override
            public void sendError(int i, String s) throws IOException {

            }

            @Override
            public void sendError(int i) throws IOException {

            }

            @Override
            public void sendRedirect(String s) throws IOException {

            }

            @Override
            public void setDateHeader(String s, long l) {

            }

            @Override
            public void addDateHeader(String s, long l) {

            }

            @Override
            public void setHeader(String s, String s1) {

            }

            @Override
            public void addHeader(String s, String s1) {

            }

            @Override
            public void setIntHeader(String s, int i) {

            }

            @Override
            public void addIntHeader(String s, int i) {

            }

            @Override
            public void setStatus(int i) {

            }

            @Override
            public void setStatus(int i, String s) {

            }

            @Override
            public int getStatus() {
                return 0;
            }

            @Override
            public String getHeader(String s) {
                return null;
            }

            @Override
            public Collection<String> getHeaders(String s) {
                return null;
            }

            @Override
            public Collection<String> getHeaderNames() {
                return null;
            }

            @Override
            public String getCharacterEncoding() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public ServletOutputStream getOutputStream() throws IOException {
                return null;
            }

            @Override
            public PrintWriter getWriter() throws IOException {
                return null;
            }

            @Override
            public void setCharacterEncoding(String s) {

            }

            @Override
            public void setContentLength(int i) {

            }

            @Override
            public void setContentLengthLong(long l) {

            }

            @Override
            public void setContentType(String s) {

            }

            @Override
            public void setBufferSize(int i) {

            }

            @Override
            public int getBufferSize() {
                return 0;
            }

            @Override
            public void flushBuffer() throws IOException {

            }

            @Override
            public void resetBuffer() {

            }

            @Override
            public boolean isCommitted() {
                return false;
            }

            @Override
            public void reset() {

            }

            @Override
            public void setLocale(Locale locale) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }
        };

        DataReceiver serv = new DataReceiver();
        serv.doPost(request, response);


    }
}