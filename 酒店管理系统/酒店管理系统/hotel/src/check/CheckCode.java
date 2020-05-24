package check;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int width = 100;
		int height = 30;
		// �Ȼ�ȡ��������
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// �Ȼ�ȡ���ʶ���
		Graphics2D g = (Graphics2D) image.getGraphics();
		// ������ɫ
		g.setColor(Color.white);
		// ��һ��ʵ�ĵľ���
		g.fillRect(0, 0, width, height);
		// ��һ���߿�
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);
		// ׼������
		String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		// ���õĺ���
		StringBuffer sb = new StringBuffer();
		// �����ȡ4���ַ�
		Random random = new Random();
		g.setColor(Color.red);
		// ��������
		g.setFont(new Font("΢���ź�", Font.BOLD, 20));
		// �����ȡ4���ַ�
		int x = 20;
		int y = 20;
		for (int i = 0; i < 4; i++) {

			// �����ת��Ч��
			/**
			 * double theta ��������ǻ��� ���� = �Ƕ� * Math.PI / 180; �����ȡ����30֮��ĽǶ� =
			 * random.nextInt(60) - 30;
			 */
			// �����ȡ����30֮��ĽǶ�
			int jiaodu = random.nextInt(60) - 30;
			double hudu = jiaodu * Math.PI / 180;
			// ������
			g.rotate(hudu, x, y);

			int index = random.nextInt(words.length());
			char ch = words.charAt(index);
			// ������������
			g.drawString(ch + "", x, y);
			// ����һ���ַ���ת��ȥ
			sb.append(ch);
			g.rotate(-hudu, x, y);
			x += 20;
		}
		System.out.println(sb.toString());
		// �����ɵ���֤�뱣�浽session�������
		HttpSession session = request.getSession();
		// ��session�����д������ɵ���֤��
		session.setAttribute("sesscode", sb.toString());

		// ��������
		g.setColor(Color.blue);
		int x1, y1;
		for (int i = 0; i < 100; i++) {
			x1 = random.nextInt(width);
			y1 = random.nextInt(height);

			g.drawLine(x1, y1, x1, y1);
		}
		// �ͷ���Դ
		g.dispose();
		// ��ͼƬ������ͻ���
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
