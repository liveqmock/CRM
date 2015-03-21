package org.jeecgframework.core.aop;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.aop.ResMime;
import org.jeecgframework.core.aop.Wrapper;
import org.springframework.util.FileCopyUtils;

public class GZipFilter implements Filter {
	private static final Logger logger = Logger.getLogger(GZipFilter.class);
	private static final String DESIGNER_PLUG_IN = "plug-in/designer";
	public void destroy() {
	}

	/**
	 * 判断浏览器是否支持GZIP
	 * 
	 * @param request
	 * @return
	 */
	private static boolean isGZipEncoding(HttpServletRequest request) {
		boolean flag = false;
		String encoding = request.getHeader("Accept-Encoding");
		if (encoding != null && encoding.indexOf("gzip") != -1) {
			flag = true;
		}
		return flag;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getRequestURI().indexOf(DESIGNER_PLUG_IN) != -1) {
			String url = req.getRequestURI();
			url = url.replaceFirst(req.getContextPath(), "");
			response.reset();
			String s = ResMime.get(url.substring(url.lastIndexOf(".")).replace(".", ""));
			if (s != null) response.setContentType(s);
			OutputStream os = null;
			InputStream is = null;
			try {
				url = url.replaceFirst(req.getContextPath(), "");
				is = this.getClass().getResourceAsStream(url);
				if (is != null) {
					os = response.getOutputStream();
					FileCopyUtils.copy(is, os);
				} else {
					logger.warn("\tdosen't find resource : "  + url);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else if (req.getRequestURI().indexOf("ReportServer") != -1) {
			chain.doFilter(request, response);
		} else {
			if (isGZipEncoding(req)) {
				Wrapper wrapper = new Wrapper(resp);
				chain.doFilter(request, wrapper);
				byte[] gzipData = gzip(wrapper.getResponseData());
				resp.addHeader("Content-Encoding", "gzip");
				resp.setContentLength(gzipData.length);
				ServletOutputStream output = response.getOutputStream();
				output.write(gzipData);
				output.flush();
			} else {
				chain.doFilter(request, response);
			}
		}

	}
	public void init(FilterConfig arg0) throws ServletException {

	}

	private byte[] gzip(byte[] data) {
		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream(10240);
		GZIPOutputStream output = null;
		try {
			output = new GZIPOutputStream(byteOutput);
			output.write(data);
		} catch (IOException e) {
		} finally {
			try {
				output.close();
			} catch (IOException e) {
			}
		}
		return byteOutput.toByteArray();
	}

}
