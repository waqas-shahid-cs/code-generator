<%@tag description="JWorks Default Page Layout Template" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<s:url value="/assets" var="assets" scope="request"/>
<s:url value="/app" var="app" scope="request"/>
<s:url value="/app/ws" var="ws" scope="request"/>


<script>
    var CJS = CJS || {};
    CJS.appPrefix = '${app}';
    CJS.assetPrefix = '${assets}';
    CJS.wsPrefix = '${ws}';
</script>

<style>
    .loadingIcon {
        background: #fff url(../images/spinner_new.gif) center center no-repeat;
        width: 16px;
        margin: 4px auto 0 auto;
        padding: 0;
        height: 16px;
    }
</style>

<!-- basic styles -->
<link rel="stylesheet" href="${assets}/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${assets}/css/font-awesome.min.css"/>
<link rel="stylesheet" href="${assets}/webfonts/ss-standard.css"/>

<!--[if IE 7]>
<link rel="stylesheet" href="${assets}/css/font-awesome-ie7.min.css"/>
<![endif]-->

<!-- page specific plugin styles -->
<link rel="stylesheet" href="${assets}/css/jquery-ui-1.10.4.custom.min.css"/>
<link rel="stylesheet" href="${assets}/css/chosen.css"/>
<link rel="stylesheet" href="${assets}/css/jquery.gritter.css"/>
<link rel="stylesheet" href="${assets}/css/jqx.base.css"/>
<link rel="stylesheet" href="${assets}/css/jqx.bootstrap.css"/>
<link rel="stylesheet" href="${assets}/css/jqx-jworks.css"/>
<%--<link rel="stylesheet" href="${assets}/css/jworks.css"/>--%>
<link rel="stylesheet" href="${assets}/css/jworks-site.css"/>
<link rel="stylesheet" href="${assets}/css/themes/jworksTheme.default.css"/>
<%--<link rel="stylesheet" href="${assets}/css/themes/jworksSkin.light.css"/>--%>
<link rel="stylesheet" href="${assets}/css/jquery.cleditor.css"/>
<link rel="stylesheet" href="${assets}/css/query-builder.default.css"/>

<script src='${assets}/js/jquery-2.1.1.min.js'></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if IE]>
<script src="${assets}/js/html5shiv.js"></script>
<script src="${assets}/js/respond.min.js"></script>
<![endif]-->

<!-- basic scripts -->
<script src="${assets}/js/moment.min.js"></script>


<!-- page specific plugin scripts -->
<%--     <script src="${assets}/js/jquery-ui-1.10.4.custom.min.js"></script>
 --%>
<script src="${assets}/js/jquery-ui-1.10.4.custom.js"></script>
<script src="${assets}/js/jworks.js"></script>
<script src="${assets}/js/jworks-polyfills.js"></script>

<script src="${assets}/js/jquery.hotkeys.js"></script>
<script src="${assets}/js/jworks.hotkeys.js"></script>

<script src="${assets}/js/jquery.formatCurrency-1.4.0.min.js"></script>
<script src="${assets}/js/chosen.jquery.min.js"></script>
<script src="${assets}/js/jquery.gritter.min.js"></script>
<script src="${assets}/js/underscore-min.js"></script>
<script src="${assets}/js/string.min.js"></script>
<script src="${assets}/js/bootstrap.min.js"></script>
<script src="${assets}/js/jqx-all.js"></script>
<script src="${assets}/js/jquery.ezstorage.js"></script>
<script src="${assets}/js/jquery.fileDownload.js"></script>
<script src="${assets}/js/cjs.cjsCache.js"></script>
<script src="${assets}/js/cjs.cjsEventBus.js"></script>
<script src="${assets}/js/sockjs-1.0.2.js"></script>
<script src="${assets}/js/stomp.js"></script>
<script src="${assets}/js/cjs.cjsMessageService.js"></script>
<script src="${assets}/js/cjs.cjsNavigation.js"></script>
<script src="${assets}/js/cjs.cjsWidget.js"></script>
<script src="${assets}/js/cjs.cjsTooltipEditor.js"></script>
<script src="${assets}/js/cjs.cjsModal.js"></script>
<script src="${assets}/js/cjs.cjsGrid.js"></script>
<script src="${assets}/js/cjs.cjsGridEdit.js"></script>
<script src="${assets}/js/cjs.cjsGridExport.js"></script>
<script src="${assets}/js/jquery.cleditor.js"></script>
<script src="${assets}/js/cjs.cjsTabs.js"></script>
<script src="${assets}/js/cjs.cjsResizable.js"></script>
<script src="${assets}/js/cjs.cjsPanel.js"></script>
<script src="${assets}/js/cjs.cjsTreeTabPanel.js"></script>
<script src="${assets}/js/cjs.cjsTreeTabSplitterPanel.js"></script>
<script src="${assets}/js/cjs.cjsModalForm.js"></script>
<script src="${assets}/js/cjs.cjsPanelEditModal.js"></script>
<script src="${assets}/js/cjs.cjsSortableRows.js"></script>
<script src="${assets}/js/cjs.cjsTooltipEditor.js"></script>
<script src="${assets}/js/cjs.cjsPageTabs.js"></script>
<script src="${assets}/js/jquery.dirtyFields.js"></script>
<script src="${assets}/js/cjs.cjsForm.js"></script>
<script src="${assets}/js/cjs.cjsFormPanel.js"></script>
<script src="${assets}/js/cjs.cjsQuickFormPanel.js"></script>
<script src="${assets}/js/cjs.cjsQuickSearchModal.js"></script>
<script src="${assets}/js/cjs.cjsEditorLookup.js"></script>
<script src="${assets}/js/cjs.cjsNameEditorLookup.js"></script>
<script src="${assets}/js/cjs.cjsEditorSelectLookup.js"></script>
<script src="${assets}/js/cjs.cjsNameEditorSelectLookup.js"></script>
<script src="${assets}/js/cjs.cjsNameEditorMultiSelectLookup.js"></script>
<script src="${assets}/js/cjs.cjsEditorButton.js"></script>
<script src="${assets}/js/cjs.cjsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsPanelSettings.js"></script>
<script src="${assets}/js/cjs.cjsReportPanel.js"></script>
<script src="${assets}/js/cjs.cjsFlexPanel.js"></script>
<script src="${assets}/js/cjs.cjsPageTabSettings.js"></script>
<script src="${assets}/js/cjs.cjsGridPanelSettings.js"></script>
<script src="${assets}/js/cjs.cjsFormPanelSettings.js"></script>
<script src="${assets}/js/cjs.cjsPage.js"></script>
<script src="${assets}/js/cjs.cjsCalendarChartPanel.js"></script>
<script src="${assets}/js/cjs.cjsChartPanel.js"></script>
<script src="${assets}/js/cjs.cjsCheckInPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseNotesPanel.js"></script>
<script src="${assets}/js/cjs.cjsCasePage.js"></script>
<script src="${assets}/js/cjs.cjsCaseUpdateExpressModal.js"></script>
<script src="${assets}/js/cjs.cjsNamePage.js"></script>
<script src="${assets}/js/cjs.cjsDashboardPage.js"></script>
<script src="${assets}/js/cjs.cjsSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsSearchFormPanel.js"></script>
<script src="${assets}/js/cjs.cjsSentencesPanel.js"></script>
<script src="${assets}/js/cjs.cjsSentencingTemplateSentencePanel.js"></script>
<script src="${assets}/js/cjs.cjsConditionsPanel.js"></script>
<script src="${assets}/js/cjs.cjsConflictsModal.js"></script>
<script src="${assets}/js/cjs.cjsContinuancesPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseBailCondViolPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseFilteredLayout.js"></script>
<script src="${assets}/js/cjs.cjsCaseSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseServiceTrackingMethodsPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseStatusHistoryPanel.js"></script>
<script src="${assets}/js/cjs.cjsNameFilteredLayout.js"></script>
<script src="${assets}/js/cjs.cjsNameSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsNameSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsStatuteSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsStatuteSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsPageHeaderFormPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseHeaderPanel.js"></script>
<script src="${assets}/js/cjs.cjsDocGenModal.js"></script>
<script src="${assets}/js/cjs.cjsDocketPanel.js"></script>
<script src="${assets}/js/cjs.cjsDocketResequenceModal.js"></script>
<script src="${assets}/js/cjs.cjsNameHeaderPanel.js"></script>
<script src="${assets}/js/cjs.cjsNameAddressesPanel.js"></script>
<script src="${assets}/js/cjs.cjsNamePersonAttributePanel.js"></script>
<script src="${assets}/js/cjs.cjsNamePhoneNumbersPanel.js"></script>
<script src="${assets}/js/cjs.cjsActionButtons.js"></script>
<script src="${assets}/js/cjs.cjsActionMenu.js"></script>
<script src="${assets}/js/cjs.cjsMessagesPanel.js"></script>
<script src="${assets}/js/cjs.cjsNoteEditor.js"></script>
<script src="${assets}/js/cjs.cjsFilingCabinet.js"></script>
<script src="${assets}/js/cjs.cjsFilingCabinetCaseDockets.js"></script>
<script src="${assets}/js/cjs.cjsFilingCabinetCaseEvents.js"></script>
<script src="${assets}/js/cjs.cjsFilingCabinetCaseNotes.js"></script>
<script src="${assets}/js/cjs.cjsNameFilingCabinet.js"></script>
<script src="${assets}/js/cjs.cjsCaseFolderSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsCaseFolderSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseFolderSearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableAdmin.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditor.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorTabbed.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorAssignmentPoolTabs.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorDispositionCodeCaseTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorDocketCodeCaseTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorEventCategoryCaseTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorEventTabs.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorNotificationTypeTabs.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorTimeGuidelineTabs.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorEventStatuses.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorTaskGroupsAndTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorObligationTypeAmounts.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorParticipantRolesCaseTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorDocumentTemplates.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorCaseStatuses.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorCaseSubStatuses.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorAlertStatuses.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorWarrantStatuses.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorBailStatuses.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorPaplPeriodTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorCashbookTabs.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorScrFormCodes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorBlocks.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorApiTranslations.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorApiExchangesTabs.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorServiceTrackingMethodTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorServiceTrackingTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorUserGroupFunctionTypes.js"></script>
<script src="${assets}/js/cjs.cjsTree.js"></script>
<script src="${assets}/js/cjs.cjsList.js"></script>
<script src="${assets}/js/cjs.cjsDefaultFileStructure.js"></script>
<script src="${assets}/js/cjs.cjsConsolidatedChargesPanel.js"></script>
<script src="${assets}/js/cjs.cjsConsolidatedPaymentsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentReceiptModal.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanDetailsModal.js"></script>
<script src="${assets}/js/cjs.cjsNonCaseReceiptObligationsPanel.js"></script>
<script src="${assets}/js/cjs.cjsNonCaseReceiptFormPanel.js"></script>
<script src="${assets}/js/cjs.cjsConfirmationModal.js"></script>
<script src="${assets}/js/cjs.cjsHoldingAccountsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentDetailsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentObligationsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentAccountsPanel.js"></script>
<script src="${assets}/js/cjs.cjsComboBox.js"></script>
<script src="${assets}/js/cjs.cjsComboBoxCodeValues.js"></script>
<script src="${assets}/js/cjs.cjsComboBoxAgency.js"></script>
<script src="${assets}/js/cjs.cjsComboBoxCity.js"></script>
<script src="${assets}/js/cjs.cjsComboBoxZipCode.js"></script>
<script src="${assets}/js/cjs.cjsComboBoxState.js"></script>
<script src="${assets}/js/cjs.cjsComboBoxCounty.js"></script>
<script src="${assets}/js/cjs.cjsComboBoxCountry.js"></script>
<script src="${assets}/js/cjs.cjsComboBoxOffenseCode.js"></script>
<script src="${assets}/js/cjs.cjsDisbursementDetailsModal.js"></script>
<script src="${assets}/js/cjs.cjsOffenseAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsOffensePropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsUserAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsUserPropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsAgencyAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsAgencyPropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsAutoScheduleModal.js"></script>
<script src="${assets}/js/cjs.cjsCopyChargeVersionPanel.js"></script>
<script src="${assets}/js/cjs.cjsCopyCasePanel.js"></script>
<script src="${assets}/js/cjs.cjsReprintReceiptModal.js"></script>
<script src="${assets}/js/cjs.cjsRoleAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsRolePropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsRoleSecurityPanel.js"></script>
<script src="${assets}/js/cjs.cjsRollCallModal.js"></script>
<script src="${assets}/js/cjs.cjsRulingModal.js"></script>
<script src="${assets}/js/cjs.cjsFilingCabinetPropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsFinancialObligationsPanel.js"></script>
<script src="${assets}/js/cjs.cjsFinancialObligationAdjustmentsPanel.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsPanel.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsAddFilePanel.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsAddCollectionModalForm.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsDeleteCollectionModalForm.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsAddFolderModalForm.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsDeleteFolderModalForm.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsPropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsFolderPropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsCollectionsFilePropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseDispositionHistoryPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseDocketParticipantsPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantAliasPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantPhonesPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantEmailAddressesPanel.js"></script>
<script src="${assets}/js/cjs.cjsNameAliasPanel.js"></script>
<script src="${assets}/js/cjs.cjsChargeParticipantsPanel.js"></script>
<script src="${assets}/js/cjs.cjsChargeSentencesPanel.js"></script>
<script src="${assets}/js/cjs.cjsChargeVersionSentencesPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantSentencesPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantAddressesPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantAddressUpdateModal.js"></script>
<script src="${assets}/js/cjs.cjsParticipantPhoneNumberUpdateModal.js"></script>
<script src="${assets}/js/cjs.cjsParticipantEmailAddressUpdateModal.js"></script>
<script src="${assets}/js/cjs.cjsCashDrawerPanel.js"></script>
<script src="${assets}/js/cjs.cjsComponentsXrefModal.js"></script>
<script src="${assets}/js/cjs.cjsComponentsQmstXrefModal.js"></script>
<script src="${assets}/js/cjs.cjsDispositionModal.js"></script>
<script src="${assets}/js/cjs.cjsDispositionInvolvedPersonsPanel.js"></script>
<script src="${assets}/js/cjs.cjsDispositionChargeParticipantsPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseTypeSelect.js"></script>
<script src="${assets}/js/cjs.cjsCaseTypeSelectModal.js"></script>
<script src="${assets}/js/cjs.cjsFilingCabinetAddFolderModalForm.js"></script>
<script src="${assets}/js/cjs.cjsFilingCabinetFolderPropertiesPanel.js"></script>
<%-- <script src="${assets}/js/cjs.cjsUserAgencyMembershipPanel.js"></script> --%>
<script src="${assets}/js/cjs.cjsUserRolesPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseParticipantSelectGrid.js"></script>
<script src="${assets}/js/cjs.cjsCaseRemindersModal.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlansPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlansAddPlanModalForm.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlansPropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanObligationsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanNoticesSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanNoticesSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanNoticesSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsNestedGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsNumberGeneratorPanel.js"></script>
<script src="${assets}/js/cjs.cjsNumberSequenceAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsNumberSequencePropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsUserPrefs.js"></script>
<script src="${assets}/js/cjs.cjsRecentItems.js"></script>
<script src="${assets}/js/cjs.cjsReverseReceiptModal.js"></script>
<script src="${assets}/js/cjs.cjsRollupModal.js"></script>
<script src="${assets}/js/cjs.cjsEndOfDaySelectModal.js"></script>
<script src="${assets}/js/cjs.cjsEndOfDaySearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsEndOfDaySearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPagination.js"></script>
<script src="${assets}/js/cjs.cjsSystemSettingsFormPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanObligationsPanel.js"></script>
<script src="${assets}/js/cjs.cjsEndOfDayPanel.js"></script>
<script src="${assets}/js/cjs.cjsPeriodicEndOfMonthPanel.js"></script>
<script src="${assets}/js/cjs.cjsPeriodicEndOfYearPanel.js"></script>
<script src="${assets}/js/cjs.cjsTallyDetailsModal.js"></script>
<script src="${assets}/js/cjs.cjsTimeBilledPanel.js"></script>
<script src="${assets}/js/cjs.cjsExpensePanel.js"></script>
<script src="${assets}/js/cjs.cjsLayoutPinSelect.js"></script>
<script src="${assets}/js/cjs.cjsNotificationsPanel.js"></script>
<script src="${assets}/js/cjs.cjsFavoritesPanel.js"></script>
<script src="${assets}/js/cjs.cjsFavoriteSelect.js"></script>
<script src="${assets}/js/cjs.cjsEventAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventDocket.js"></script>
<script src="${assets}/js/cjs.cjsEventNotes.js"></script>
<script src="${assets}/js/cjs.cjsEventNotesPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventPropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsSentencingTemplateAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsSentencingTemplatePropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventsPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventParticipantsPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventsChargesPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantChargesPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantWhereaboutsPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantStatusesPanel.js"></script>
<script src="${assets}/js/cjs.cjsChargesPanel.js"></script>
<script src="${assets}/js/cjs.cjsChargeVersionsPanel.js"></script>
<script src="${assets}/js/cjs.cjsChargeVersionSelectModal.js"></script>
<script src="${assets}/js/cjs.cjsChargeVersionEditorSelectLookup.js"></script>
<script src="${assets}/js/cjs.cjsFinancialSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsFinancialSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseInitiationMenu.js"></script>
<script src="${assets}/js/cjs.cjsCaseInitiationForm.js"></script>
<script src="${assets}/js/cjs.cjsQuickDocketAddForm.js"></script>
<script src="${assets}/js/cjs.cjsGlobalAdjustmentForm.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInit2PtyAttyActn.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInitDfndtTraffic.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInitCrimTrafficChrgs.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInitCrimChrgVict.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInitMultPartAttoChil.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInitContributingCase.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInitJuvenileTraffic.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInitDelinquencyUnruly.js"></script>
<script src="${assets}/js/case/cjs.cjsCaseInitChildrenMultipleParties.js"></script>
<script src="${assets}/js/cjs.cjsOrganizationAgencyAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsRoleMenuSecurityPanel.js"></script>
<script src="${assets}/js/cjs.cjsOffenseEditorLookup.js"></script>
<script src="${assets}/js/cjs.cjsRoleReportSecurityPanel.js"></script>
<script src="${assets}/js/cjs.cjsReportsMenu.js"></script>
<script src="${assets}/js/cjs.cjsTextSearchCriteriaPanel.js"></script>

<script src="${assets}/js/cjs.cjsObligationAdjustmentPanel.js"></script>

<script src="${assets}/js/cjs.cjsTextSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsTextSearchResultsListPanel.js"></script>
<script src="${assets}/js/cjs.cjsTextSearchForm.js"></script>
<script src="${assets}/js/cjs.cjsTextSearchMenu.js"></script>
<script src="${assets}/js/cjs.cjsUserSettings.js"></script>
<script src="${assets}/js/cjs.cjsUserSettingsModal.js"></script>
<script src="${assets}/js/cjs.cjsUserNotesModal.js"></script>

<script src="${assets}/js/cjs.cjsCaseAgencyNumbersPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseInvolvedPersonsPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseInvolvementsPanel.js"></script>

<script src="${assets}/js/cjs.cjsBailPanel.js"></script>
<script src="${assets}/js/cjs.cjsBailCashPanel.js"></script>
<script src="${assets}/js/cjs.cjsBailPropertyPanel.js"></script>
<script src="${assets}/js/cjs.cjsBailSuretyPanel.js"></script>
<script src="${assets}/js/cjs.cjsBankCodeAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsBankCodePropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsMyTasksPanel.js"></script>
<script src="${assets}/js/cjs.cjsMyNotificationsPanel.js"></script>
<script src="${assets}/js/cjs.cjsTasksPanel.js"></script>
<script src="${assets}/js/cjs.cjsTaskOwnerHistoryPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseEventTasksPanel.js"></script>
<script src="${assets}/js/cjs.cjsNameEventTasksPanel.js"></script>
<script src="${assets}/js/cjs.cjsNameSchoolsPanel.js"></script>
<script src="${assets}/js/cjs.cjsScheduler.js"></script>
<script src="${assets}/js/cjs.cjsSchedulerPanel.js"></script>
<script src="${assets}/js/cjs.cjsCalendar.js"></script>
<script src="${assets}/js/cjs.cjsCalendarDashboardPanel.js"></script>
<script src="${assets}/js/cjs.cjsCalendarsPanel.js"></script>
<script src="${assets}/js/cjs.cjsCalendarItemModal.js"></script>

<script src="${assets}/js/cjs.cjsEntityTriggerPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowProcessExecutionsPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowProcessHistoryPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowDeploymentsPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowTriggerPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowCodeValuesPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowProcessDefinitionsPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowModelerPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowEditorPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowExecutionPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowAdministrationPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowProcessMessagesPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseWorkflowPanel.js"></script>
<script src="${assets}/js/cjs.cjsExecuteWorkflowPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseWorkflowActivityStatusPanel.js"></script>

<script src="${assets}/js/cjs.cjsEntityTriggerAdminPage.js"></script>
<script src="${assets}/js/cjs.cjsEntityTriggerAdminPanel.js"></script>

<script src="${assets}/js/cjs.cjsTransferFunds.js"></script>

<script src="${assets}/js/jquery.inputmask.bundle.min.js"></script>
<script src="${assets}/js/cjs.cjsMaskedInput.js"></script>

<script src="${assets}/js/jquery.cookie.js"></script>
<script src="${assets}/js/URI.js"></script>

<script type="text/javascript" src="${assets}/js/cjs.cjsPageLayout.js"></script>
<script type="text/javascript" src="${assets}/js/jquery.form.js"></script>
<script type="text/javascript" src="${assets}/js/jquery.loadmask.min.js"></script>

<script src="${assets}/js/query-builder.standalone.js"></script>

<script src="${assets}/js/cjs.cjsObligationTypesAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsObligationTypesPropertiesPanel.js"></script>

<script src="${assets}/js/cjs.cjsCityAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsCityPropertiesPanel.js"></script>

<script src="${assets}/js/cjs.cjsZipAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsZipPropertiesPanel.js"></script>

<script src="${assets}/js/cjs.cjsFundDistributionAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsFundDistributionPropertiesPanel.js"></script>

<script src="${assets}/js/cjs.cjsAlertModal.js"></script>
<script src="${assets}/js/cjs.cjsAlertPanel.js"></script>

<script src="${assets}/js/cjs.cjsWarrantChargesPanel.js"></script>
<script src="${assets}/js/cjs.cjsWarrantModal.js"></script>
<script src="${assets}/js/cjs.cjsWarrantPanel.js"></script>
<script src="${assets}/js/cjs.cjsWarrantsAlerts.js"></script>

<script src="${assets}/js/cjs.cjsAssignmentPoolAdminPanel.js"></script>
<script src="${assets}/js/cjs.cjsAssignmentPoolCaseTypesPanel.js"></script>
<script src="${assets}/js/cjs.cjsAssignmentPoolOffenseGroupsPanel.js"></script>
<script src="${assets}/js/cjs.cjsAssignmentPoolParticipantsPanel.js"></script>
<script src="${assets}/js/cjs.cjsAssignmentPoolPropertiesPanel.js"></script>
<script src="${assets}/js/cjs.cjsCashierDrawerSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsCashierDrawerSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsCashierDrawerSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsFinancialSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsCheckSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsCheckSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsPrintChecks.js"></script>
<script src="${assets}/js/cjs.cjsPrintChecksModal.js"></script>
<script src="${assets}/js/cjs.cjsProcessChecks.js"></script>
<script src="${assets}/js/cjs.cjsProcessCheckResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsProcessCheckCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanExtRequestsPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseScrHistoryPanel.js"></script>
<script src="${assets}/js/cjs.cjsOutcomeXrefModal.js"></script>
<script src="${assets}/js/cjs.cjsRecommendedSentencesModal.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorCaseAgencyNumberTypes.js"></script>
<script src="${assets}/js/cjs.cjsTimeGuideline.js"></script>
<script src="${assets}/js/cjs.cjsTimeGuidelineItems.js"></script>
<script src="${assets}/js/cjs.cjsTgmConditions.js"></script>
<script src="${assets}/js/cjs.cjsTgmDateFormulas.js"></script>
<script src="${assets}/js/cjs.cjsRestrictions.js"></script>
<script src="${assets}/js/cjs.cjsCaseAgencyNumberTypesRestrictions.js"></script>
<script src="${assets}/js/cjs.cjsCasePanelSecurity.js"></script>
<script src="${assets}/js/cjs.cjsNamePanelPersonRoleSecurity.js"></script>
<script src="${assets}/js/cjs.cjsCaseAppealsPanel.js"></script>
<script src="${assets}/js/cjs.cjsWarrantStatusHistoryPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventsSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsEventsSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventsSearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventsGenerateModal.js"></script>
<script src="${assets}/js/cjs.cjsInCourtPage.js"></script>
<script src="${assets}/js/cjs.cjsInCourtSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtSearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventProcessingPage.js"></script>
<script src="${assets}/js/cjs.cjsEventProcessingSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventProcessingSearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsEventsUpdateTabbedModal.js"></script>
<script src="${assets}/js/cjs.cjsEventsUpdateAll.js"></script>
<script src="${assets}/js/cjs.cjsSetEvent.js"></script>
<script src="${assets}/js/cjs.cjsSetDocketEvent.js"></script>
<script src="${assets}/js/cjs.cjsSetTask.js"></script>
<script src="${assets}/js/cjs.cjsSplitter.js"></script>
<script src="${assets}/js/cjs.cjsOffersPanel.js"></script>
<script src="${assets}/js/cjs.cjsServiceTrackingCalendar.js"></script>
<script src="${assets}/js/cjs.cjsServiceTrackingCalendarPanel.js"></script>
<script src="${assets}/js/cjs.cjsServiceTrackingInitForm.js"></script>
<script src="${assets}/js/cjs.cjsServiceTrackingResultsSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsServiceTrackingResultsSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsServiceTrackingResultsSearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsServiceTrackingResultsUpdateModal.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanMemberSelectModal.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanMemberEditorLookup.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanMemberSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsPaymentPlanMemberSearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowFormModal.js"></script>
<script src="${assets}/js/cjs.cjsWorkflowMessages.js"></script>

<script src="${assets}/js/cjs.cjsPublicRequestHeaderPanel.js"></script>
<script src="${assets}/js/cjs.cjsPublicRequestPage.js"></script>
<script src="${assets}/js/cjs.cjsPublicRequestSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsPublicRequestSearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPublicRequestSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsPublicRequestPanel.js"></script>

<script src="${assets}/js/cjs.cjsAssociatedPersonPanel.js"></script>

<script src="${assets}/js/cjs.cjsSupremeCourtDataSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsSupremeCourtDataSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsSupremeCourtDataSearchResultsPanel.js"></script>

<script src="${assets}/js/cjs.cjsBatchQueueSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsBatchQueueSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsBatchQueueSearchResultsPanel.js"></script>

<script src="${assets}/js/cjs.cjsInCourtHeaderPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtFormPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtChargePanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtDocketPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtConditionsPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtEventPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtObligationPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtObligationAdjustmentPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtSentencePanel.js"></script>
<script src="${assets}/js/cjs.cjsSubscriptionMessages.js"></script>
<script src="${assets}/js/cjs.cjsInCourtNewEventsPanel.js"></script>
<script src="${assets}/js/cjs.cjsConditionTextModal.js"></script>
<script src="${assets}/js/cjs.cjsConditionPickerModal.js"></script>
<script src="${assets}/js/cjs.cjsConditionTypesPanel.js"></script>
<script src="${assets}/js/cjs.cjsObligationPickerModal.js"></script>
<script src="${assets}/js/cjs.cjsSentencePickerModal.js"></script>
<script src="${assets}/js/cjs.cjsDocketPickerModal.js"></script>
<script src="${assets}/js/cjs.cjsDocketTypesPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtDocumentsPanel.js"></script>
<script src="${assets}/js/cjs.cjsInCourtCheckInPanel.js"></script>
<script src="${assets}/js/cjs.cjsCaseParticipantReassignmentModal.js"></script>
<script src="${assets}/js/cjs.cjsMergePerson.js"></script>
<script src="${assets}/js/cjs.cjsPersonPhotoModal.js"></script>
<script src="${assets}/js/cjs.cjsPersonReassignmentSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsPersonReassignmentSearchResultsPanel.js"></script>
<script src="${assets}/js/cjs.cjsPersonReassignmentPage.js"></script>
<script src="${assets}/js/cjs.cjsCheckDetailsModal.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorLookup.js"></script>
<script src="${assets}/js/cjs.cjsEventPanelEditModal.js"></script>
<script src="${assets}/js/cjs.cjsNotificationPanelEditModal.js"></script>

<script src="${assets}/js/cjs.cjsParticipantSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsParticipantSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsParticipantSearchResultsGridPanel.js"></script>

<script src="${assets}/js/cjs.cjsNotificationSearchPage.js"></script>
<script src="${assets}/js/cjs.cjsNotificationSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsNotificationSearchResultsGridPanel.js"></script>

<script src="${assets}/js/cjs.cjsFolderDestructionDateUpdate.js"></script>
<script src="${assets}/js/cjs.cjsFolderDestructionDateUpdateModal.js"></script>
<script src="${assets}/js/cjs.cjsReviewNotificationsChartPanel.js"></script>
<script src="${assets}/js/cjs.cjsReviewNotificationsPanel.js"></script>
<script src="${assets}/js/cjs.cjsTimeSheet.js"></script>
<script src="${assets}/js/cjs.cjsAppLogsPanel.js"></script>
<script src="${assets}/js/cjs.cjsAppLogFileViewPanel.js"></script>
<script src="${assets}/js/cjs.cjsDocumentIntakeModal.js"></script>
<script src="${assets}/js/cjs.cjsCaseVehiclePanel.js"></script>

<%--isotype filtering--%>
<script src="${assets}/js/cjs.cjsCodeTableEditorQualifiedLists.js"></script>
<script src="${assets}/js/cjs.cjsQualifiedListsPage.js"></script>
<script src="${assets}/js/cjs.cjsQualifiedListsSearchCriteriaPanel.js"></script>
<script src="${assets}/js/cjs.cjsQualifiedListsSearchResultsGridPanel.js"></script>
<script src="${assets}/js/cjs.cjsNameCaseRecusalsPanel.js"></script>
<script src="${assets}/js/cjs.cjsAddressTypesRestrictions.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorAddressTypes.js"></script>
<script src="${assets}/js/cjs.cjsCaseAddressesPanel.js"></script>
<script src="${assets}/js/cjs.cjsChargeAddressesPanel.js"></script>
<script src="${assets}/js/cjs.cjsPhoneTypesRestrictions.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorPhoneTypes.js"></script>
<script src="${assets}/js/cjs.cjsCodeTableEditorEmailTypes.js"></script>
<script src="${assets}/js/cjs.cjsEmailTypesRestrictions.js"></script>
<script src="${assets}/js/cjs.cjsAgencyEmailAddressesPanel.js"></script>
<script src="${assets}/js/cjs.cjsNameEmailAddressesPanel.js"></script>
<script src="${assets}/js/cjs.cjsAgencyPhonesPanel.js"></script>

<script src="${assets}/js/cjs.cjsCodeTableEditorOrgCodeMapping.js"></script>
<%--isotype filtering--%>
<%--<script src="${assets}/js/isotope.pkgd.min.js"></script>--%>


<%--    <script src="${assets}/js/jqxdatetimeinput.js"></script>  --%>
<%--    <script src="${assets}/js/jqxcalendar.js"></script>  --%>
<script src="${assets}/js/globalize.js"></script>
<script src="${assets}/js/cjs.cjsTimerFactory.js"></script>
<script src="${assets}/js/cjs.cjsSessionTimer.js"></script>
<%--     <script>var require={baseUrl:"${assets}/js"};</script>
    <script data-main="main" src="${assets}/js/require.js"></script>
 --%>
<script>
    $.extend($.gritter.options, {
        //position: 'bottom-left', // defaults to 'top-right' but can be 'bottom-left', 'bottom-right', 'top-left', 'top-right' (added in 1.7.1)
        fade_in_speed: 'medium', // how fast notifications fade in (string or int)
        fade_out_speed: 750, // how fast the notices fade out
        time: 6000 // hang on the screen for...
    });
</script>
