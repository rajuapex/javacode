<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions"
	xmlns:xdt="http://www.w3.org/2005/xpath-datatypes">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/">
		<xsl:variable name="page.height" select="&quot;297mm&quot;" />
		<xsl:variable name="page.width" select="&quot;210mm&quot;" />
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="firstpage"
					page-height="{$page.height}" page-width="{$page.width}" margin-top="0.0cm"
					margin-bottom="0.5cm">
					<fo:region-body margin-top="5.0cm" margin-bottom="1.0cm"
						margin-left="1.0cm" margin-right="0.5cm" background-repeat="no-repeat" />
					<fo:region-before extent="4.3cm" region-name="page-before" />
					<fo:region-after extent="2.5cm" region-name="after" />
				</fo:simple-page-master>
				<fo:simple-page-master master-name="page"
					page-height="{$page.height}" page-width="{$page.width}" margin-top="0.0cm"
					margin-bottom="0.5cm">
					<fo:region-body margin-top="1.5cm" margin-bottom="1.0cm"
						margin-left="1.0cm" margin-right="0.5cm" background-repeat="no-repeat" />
					<fo:region-after extent="2.5cm" region-name="after" />
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="document">
					<fo:repeatable-page-master-alternatives>
						<fo:conditional-page-master-reference
							page-position="first" master-reference="firstpage" />
						<fo:conditional-page-master-reference
							page-position="rest" master-reference="page" />
					</fo:repeatable-page-master-alternatives>
				</fo:page-sequence-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="document">
				<fo:static-content flow-name="page-before">
					<fo:block>
						<xsl:call-template name="first-page-header" />
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="after">
					<xsl:call-template name="footer" />
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:apply-templates />
					</fo:block>
				</fo:flow>

			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template name="first-page-header">
		<fo:block background-color="#0070C0" color="#FFFFFF">
			<fo:block font-size="12pt" font-family="sans-serif"
				text-align-last="left" margin-left="0.5cm" margin-top="0.5cm">
				<fo:table table-layout="fixed" width="100%">
					<fo:table-column column-number="1"
						column-width="proportional-column-width(1)" />
					<fo:table-column column-number="2" column-width="12cm" />
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell>
								<fo:block>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell>
								<fo:block color="#D7FF97">All Hotel Reservations
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
			</fo:block>
		</fo:block>
	</xsl:template>

	<xsl:template match="reservations">
		<fo:block font-size="8pt" font-family="sans-serif"
			text-align-last="left" margin-top="0.5cm">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-column column-number="1" column-width="2cm" />
				<fo:table-column column-number="2" column-width="proportional-column-width(1)" />
				<fo:table-column column-number="3" column-width="3cm" />
				<fo:table-column column-number="4" column-width="2cm" />
				<fo:table-header>
					<fo:table-row>
						<fo:table-cell border="1pt solid black" padding="4pt"
							background-color="#0070C0" color="#FFFFFF">
							<fo:block font-weight="bold">Reservation Number</fo:block>
						</fo:table-cell>
						<fo:table-cell border="1pt solid black" padding="4pt"
							background-color="#0070C0" color="#FFFFFF">
							<fo:block font-weight="bold">Name On Reservation</fo:block>
						</fo:table-cell>
						<fo:table-cell border="1pt solid black" padding="4pt"
							background-color="#0070C0" color="#FFFFFF">
							<fo:block font-weight="bold">Check In</fo:block>
						</fo:table-cell>
						<fo:table-cell border="1pt solid black" padding="4pt"
							background-color="#0070C0" color="#FFFFFF">
							<fo:block font-weight="bold">Number Of Nights</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-header>
				<fo:table-body>
					<xsl:apply-templates />
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<xsl:template match="reservation">
		<fo:table-row>
			<fo:table-cell border="1pt solid black" padding="4pt">
				<fo:block>
					<xsl:value-of select="reservationNumber" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell border="1pt solid black" padding="4pt">
				<fo:block>
					<xsl:value-of select="nameOnReservation" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell border="1pt solid black" padding="4pt">
				<fo:block>
					 <xsl:value-of select="checkIn" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell border="1pt solid black" padding="4pt">
				<fo:block>
					<xsl:value-of select="numberOfNights" />
					nights
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	<xsl:template name="footer">
		<fo:block text-align="center" font-size="9pt">
			<xsl:text>Trivera Technologies, LLC. Developer IT Training, Mentoring &amp; Courseware Solutions </xsl:text>
		</fo:block>
		<fo:block text-align="center" font-size="9pt">
			<xsl:text> www.triveratech.com</xsl:text>
		</fo:block>
	</xsl:template>
</xsl:stylesheet>