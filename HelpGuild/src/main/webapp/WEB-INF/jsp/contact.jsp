<!-- contact.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<u><strong style="font-size: medium;">Contact Details:</strong></u>
<address>
  <strong>Help Guild, Inc.</strong><br>
  ${contact.contactName}<br>
  ${contact.address} ${contact.pin}<br>
  <abbr title="Phone">P:</abbr> ${contact.mobile}
</address>

<address>
  <strong>Full Name</strong><br>
  <a href="mailto:#">bsrinadh@helpguild.com</a>
</address>