<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        @page {
            margin: 0;
        }
    </style>
</head>
<body style="margin: 0px;
            padding: 0px;
			font: 100% SimSun, Microsoft YaHei, Times New Roman, Verdana, Arial, Helvetica, sans-serif;
            color: #000;">
<div style="height: auto;
			margin: 0 auto;
			margin-top: 20px;
			padding: 20px;
            border: 1px solid #eee;">
    <div>
        <p style="margin-bottom: 10px;">${jobInfor}</p>
        <table style="border-collapse: collapse;">
            <tr>
                <th style="padding: .65em;background: #666;border: 1px solid #777;color: #fff;">${jobName}</th>
                <th style="padding: .65em;background: #666;border: 1px solid #777;color: #fff;">${jobMethod}</th>
                <th style="padding: .65em;background: #666;border: 1px solid #777;color: #fff;">${jobExpress}</th>
                <th style="padding: .65em;background: #666;border: 1px solid #777;color: #fff;">${jobDes}</th>
            </tr>
            <tr>
                <td style="padding: .65em;border: 1px solid#777;">${task.jobName}</td>
                <td style="padding: .65em;border: 1px solid#777;">${task.invokeTarget}</td>
                <td style="padding: .65em;border: 1px solid#777;">${task.cronExpression}</td>
                <td style="padding: .65em;border: 1px solid#777;">${task.jobDesc}</td>
            </tr>
        </table>
    </div>
    <div>
        <p style="margin-bottom: 10px;">${jobException}</p>
        <pre style="position: relative;
  padding: 15px;
  line-height: 20px;
  border-left: 5px solid #ddd;
  color: #333;
  font-family: Courier New, serif;
  font-size: 12px">
        ${msg}
        </pre>
    </div>
    <div class="foot-hr hr" style="margin: 0 auto;
			z-index: 111;
			width: 800px;
			margin-top: 30px;
			border-top: 1px solid #DA251D;">
    </div>
    <div style="text-align: center;
			font-size: 12px;
			padding: 20px 0px;
			font-family: Microsoft YaHei;">
    ${jobCopy}
    </div>

</div>
</div>
</body>
</html>