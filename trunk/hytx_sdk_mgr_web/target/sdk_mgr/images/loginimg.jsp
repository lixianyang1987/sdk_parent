<%@ page autoFlush="false"
	import="java.awt.*,java.awt.image.*,com.sun.image.codec.jpeg.*,java.util.*"%>
<%!Color getRandColor(int fc, int bc) {
		Random random1 = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random1.nextInt(bc - fc);
		int g = fc + random1.nextInt(bc - fc);
		int b = fc + random1.nextInt(bc - fc);
		return new Color(r, g, b);
	}%>
<%
	out.clear();
	response.setContentType("image/jpeg");
	response.addHeader("pragma", "NO-cache");
	response.addHeader("Cache-Control", "no-cache");
	response.addDateHeader("Expries", 0);
	int width = 60, height = 35;
	BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	g.setColor(getRandColor(200, 250));
	g.fillRect(0, 0, width, height);
	g.setColor(Color.BLUE);
	for (int i = 0; i < 15; i++) {
		Random random2 = new Random();
		int x = random2.nextInt(width);
		int y = random2.nextInt(height);
		int xl = random2.nextInt(8);
		int yl = random2.nextInt(8);
		g.drawLine(x, y, x + xl, y + yl);
	}
	g.setFont(new Font("Simsun", Font.BOLD, 20));
	Random random = new Random();
	String sRand = "";
	for (int i = 0; i < 4; i++) {
		String rand = String.valueOf(random.nextInt(10));
		sRand += rand;
		g.setColor(new Color(20 + random.nextInt(110), 20 + random
		.nextInt(110), 20 + random.nextInt(110)));
		g.drawString(rand, 50 * 4 + 10, 20);
	}
	g.drawString(sRand, 10, 25);
	session.setAttribute("vcode", sRand);
	g.dispose();
	ServletOutputStream outStream = response.getOutputStream();
	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outStream);
	encoder.encode(image);
	System.out.println(session.getAttribute("vcode"));
	outStream.close();
	out.clear();
    out = pageContext.pushBody();
	
%>
