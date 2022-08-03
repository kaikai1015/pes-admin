
package sinexcel.wsc.soap.ess;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sinexcel.wsc.soap.ess package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetRequestStateResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "getRequestStateResponse");
    private final static QName _SubmitRequest_QNAME = new QName("http://xmlns.oracle.com/scheduler", "submitRequest");
    private final static QName _SubmitRecurringRequestResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "submitRecurringRequestResponse");
    private final static QName _OnJobCompletion_QNAME = new QName("http://xmlns.oracle.com/scheduler", "onJobCompletion");
    private final static QName _SetNLSOptions_QNAME = new QName("http://xmlns.oracle.com/scheduler", "setNLSOptions");
    private final static QName _SetAsyncRequestStatusResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "setAsyncRequestStatusResponse");
    private final static QName _DeleteRequestResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "deleteRequestResponse");
    private final static QName _SetSubmitArgsResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "setSubmitArgsResponse");
    private final static QName _GetRequestDetailResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "getRequestDetailResponse");
    private final static QName _PurgeRequestResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "purgeRequestResponse");
    private final static QName _AddPPActionsResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "addPPActionsResponse");
    private final static QName _RequestNotFoundException_QNAME = new QName("http://xmlns.oracle.com/scheduler", "RequestNotFoundException");
    private final static QName _SubmitRecurringRequest_QNAME = new QName("http://xmlns.oracle.com/scheduler", "submitRecurringRequest");
    private final static QName _DeleteRequest_QNAME = new QName("http://xmlns.oracle.com/scheduler", "deleteRequest");
    private final static QName _PurgeRequest_QNAME = new QName("http://xmlns.oracle.com/scheduler", "purgeRequest");
    private final static QName _SetNLSOptionsResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "setNLSOptionsResponse");
    private final static QName _SetStepsArgsResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "setStepsArgsResponse");
    private final static QName _CheckInCancelling_QNAME = new QName("http://xmlns.oracle.com/scheduler", "checkInCancelling");
    private final static QName _ReleaseRequestResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "releaseRequestResponse");
    private final static QName _GetCompletionStatus_QNAME = new QName("http://xmlns.oracle.com/scheduler", "getCompletionStatus");
    private final static QName _HoldRequestResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "holdRequestResponse");
    private final static QName _NotFoundException_QNAME = new QName("http://xmlns.oracle.com/scheduler", "NotFoundException");
    private final static QName _GetRequestState_QNAME = new QName("http://xmlns.oracle.com/scheduler", "getRequestState");
    private final static QName _HoldRequest_QNAME = new QName("http://xmlns.oracle.com/scheduler", "holdRequest");
    private final static QName _SetStepsArgs_QNAME = new QName("http://xmlns.oracle.com/scheduler", "setStepsArgs");
    private final static QName _GetRequestExecutionContext_QNAME = new QName("http://xmlns.oracle.com/scheduler", "getRequestExecutionContext");
    private final static QName _ValidationException_QNAME = new QName("http://xmlns.oracle.com/scheduler", "ValidationException");
    private final static QName _IllegalStateException_QNAME = new QName("http://xmlns.oracle.com/scheduler", "IllegalStateException");
    private final static QName _NotAllowedException_QNAME = new QName("http://xmlns.oracle.com/scheduler", "NotAllowedException");
    private final static QName _SetSubmitArgs_QNAME = new QName("http://xmlns.oracle.com/scheduler", "setSubmitArgs");
    private final static QName _SubmitRequestResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "submitRequestResponse");
    private final static QName _CheckInCancellingResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "checkInCancellingResponse");
    private final static QName _ReleaseRequest_QNAME = new QName("http://xmlns.oracle.com/scheduler", "releaseRequest");
    private final static QName _CancelRequest_QNAME = new QName("http://xmlns.oracle.com/scheduler", "cancelRequest");
    private final static QName _IllegalArgumentException_QNAME = new QName("http://xmlns.oracle.com/scheduler", "IllegalArgumentException");
    private final static QName _SetAsyncRequestStatus_QNAME = new QName("http://xmlns.oracle.com/scheduler", "setAsyncRequestStatus");
    private final static QName _AddPPActions_QNAME = new QName("http://xmlns.oracle.com/scheduler", "addPPActions");
    private final static QName _RuntimeServiceException_QNAME = new QName("http://xmlns.oracle.com/scheduler", "RuntimeServiceException");
    private final static QName _SubmitInstantRecurringRequest_QNAME = new QName("http://xmlns.oracle.com/scheduler", "submitInstantRecurringRequest");
    private final static QName _GetRequestDetail_QNAME = new QName("http://xmlns.oracle.com/scheduler", "getRequestDetail");
    private final static QName _SubmitInstantRecurringRequestResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "submitInstantRecurringRequestResponse");
    private final static QName _GetRequestExecutionContextResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "getRequestExecutionContextResponse");
    private final static QName _CancelRequestResponse_QNAME = new QName("http://xmlns.oracle.com/scheduler", "cancelRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sinexcel.wsc.soap.ess
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IllegalStateException }
     * 
     */
    public IllegalStateException createIllegalStateException() {
        return new IllegalStateException();
    }

    /**
     * Create an instance of {@link GetRequestExecutionContext }
     * 
     */
    public GetRequestExecutionContext createGetRequestExecutionContext() {
        return new GetRequestExecutionContext();
    }

    /**
     * Create an instance of {@link ValidationException }
     * 
     */
    public ValidationException createValidationException() {
        return new ValidationException();
    }

    /**
     * Create an instance of {@link NotAllowedException }
     * 
     */
    public NotAllowedException createNotAllowedException() {
        return new NotAllowedException();
    }

    /**
     * Create an instance of {@link SetSubmitArgs }
     * 
     */
    public SetSubmitArgs createSetSubmitArgs() {
        return new SetSubmitArgs();
    }

    /**
     * Create an instance of {@link GetCompletionStatus }
     * 
     */
    public GetCompletionStatus createGetCompletionStatus() {
        return new GetCompletionStatus();
    }

    /**
     * Create an instance of {@link HoldRequestResponse }
     * 
     */
    public HoldRequestResponse createHoldRequestResponse() {
        return new HoldRequestResponse();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link ReleaseRequestResponse }
     * 
     */
    public ReleaseRequestResponse createReleaseRequestResponse() {
        return new ReleaseRequestResponse();
    }

    /**
     * Create an instance of {@link HoldRequest }
     * 
     */
    public HoldRequest createHoldRequest() {
        return new HoldRequest();
    }

    /**
     * Create an instance of {@link SetStepsArgs }
     * 
     */
    public SetStepsArgs createSetStepsArgs() {
        return new SetStepsArgs();
    }

    /**
     * Create an instance of {@link GetRequestState }
     * 
     */
    public GetRequestState createGetRequestState() {
        return new GetRequestState();
    }

    /**
     * Create an instance of {@link RuntimeServiceException }
     * 
     */
    public RuntimeServiceException createRuntimeServiceException() {
        return new RuntimeServiceException();
    }

    /**
     * Create an instance of {@link SubmitInstantRecurringRequest }
     * 
     */
    public SubmitInstantRecurringRequest createSubmitInstantRecurringRequest() {
        return new SubmitInstantRecurringRequest();
    }

    /**
     * Create an instance of {@link GetRequestDetail }
     * 
     */
    public GetRequestDetail createGetRequestDetail() {
        return new GetRequestDetail();
    }

    /**
     * Create an instance of {@link AddPPActions }
     * 
     */
    public AddPPActions createAddPPActions() {
        return new AddPPActions();
    }

    /**
     * Create an instance of {@link GetRequestExecutionContextResponse }
     * 
     */
    public GetRequestExecutionContextResponse createGetRequestExecutionContextResponse() {
        return new GetRequestExecutionContextResponse();
    }

    /**
     * Create an instance of {@link CancelRequestResponse }
     * 
     */
    public CancelRequestResponse createCancelRequestResponse() {
        return new CancelRequestResponse();
    }

    /**
     * Create an instance of {@link SubmitInstantRecurringRequestResponse }
     * 
     */
    public SubmitInstantRecurringRequestResponse createSubmitInstantRecurringRequestResponse() {
        return new SubmitInstantRecurringRequestResponse();
    }

    /**
     * Create an instance of {@link ReleaseRequest }
     * 
     */
    public ReleaseRequest createReleaseRequest() {
        return new ReleaseRequest();
    }

    /**
     * Create an instance of {@link CancelRequest }
     * 
     */
    public CancelRequest createCancelRequest() {
        return new CancelRequest();
    }

    /**
     * Create an instance of {@link SubmitRequestResponse }
     * 
     */
    public SubmitRequestResponse createSubmitRequestResponse() {
        return new SubmitRequestResponse();
    }

    /**
     * Create an instance of {@link CheckInCancellingResponse }
     * 
     */
    public CheckInCancellingResponse createCheckInCancellingResponse() {
        return new CheckInCancellingResponse();
    }

    /**
     * Create an instance of {@link SetAsyncRequestStatus }
     * 
     */
    public SetAsyncRequestStatus createSetAsyncRequestStatus() {
        return new SetAsyncRequestStatus();
    }

    /**
     * Create an instance of {@link IllegalArgumentException }
     * 
     */
    public IllegalArgumentException createIllegalArgumentException() {
        return new IllegalArgumentException();
    }

    /**
     * Create an instance of {@link SetSubmitArgsResponse }
     * 
     */
    public SetSubmitArgsResponse createSetSubmitArgsResponse() {
        return new SetSubmitArgsResponse();
    }

    /**
     * Create an instance of {@link GetRequestDetailResponse }
     * 
     */
    public GetRequestDetailResponse createGetRequestDetailResponse() {
        return new GetRequestDetailResponse();
    }

    /**
     * Create an instance of {@link PurgeRequestResponse }
     * 
     */
    public PurgeRequestResponse createPurgeRequestResponse() {
        return new PurgeRequestResponse();
    }

    /**
     * Create an instance of {@link SubmitRequest }
     * 
     */
    public SubmitRequest createSubmitRequest() {
        return new SubmitRequest();
    }

    /**
     * Create an instance of {@link SubmitRecurringRequestResponse }
     * 
     */
    public SubmitRecurringRequestResponse createSubmitRecurringRequestResponse() {
        return new SubmitRecurringRequestResponse();
    }

    /**
     * Create an instance of {@link OnJobCompletion }
     * 
     */
    public OnJobCompletion createOnJobCompletion() {
        return new OnJobCompletion();
    }

    /**
     * Create an instance of {@link GetRequestStateResponse }
     * 
     */
    public GetRequestStateResponse createGetRequestStateResponse() {
        return new GetRequestStateResponse();
    }

    /**
     * Create an instance of {@link SetAsyncRequestStatusResponse }
     * 
     */
    public SetAsyncRequestStatusResponse createSetAsyncRequestStatusResponse() {
        return new SetAsyncRequestStatusResponse();
    }

    /**
     * Create an instance of {@link DeleteRequestResponse }
     * 
     */
    public DeleteRequestResponse createDeleteRequestResponse() {
        return new DeleteRequestResponse();
    }

    /**
     * Create an instance of {@link SetNLSOptions }
     * 
     */
    public SetNLSOptions createSetNLSOptions() {
        return new SetNLSOptions();
    }

    /**
     * Create an instance of {@link CheckInCancelling }
     * 
     */
    public CheckInCancelling createCheckInCancelling() {
        return new CheckInCancelling();
    }

    /**
     * Create an instance of {@link SetStepsArgsResponse }
     * 
     */
    public SetStepsArgsResponse createSetStepsArgsResponse() {
        return new SetStepsArgsResponse();
    }

    /**
     * Create an instance of {@link AddPPActionsResponse }
     * 
     */
    public AddPPActionsResponse createAddPPActionsResponse() {
        return new AddPPActionsResponse();
    }

    /**
     * Create an instance of {@link RequestNotFoundException }
     * 
     */
    public RequestNotFoundException createRequestNotFoundException() {
        return new RequestNotFoundException();
    }

    /**
     * Create an instance of {@link PurgeRequest }
     * 
     */
    public PurgeRequest createPurgeRequest() {
        return new PurgeRequest();
    }

    /**
     * Create an instance of {@link SetNLSOptionsResponse }
     * 
     */
    public SetNLSOptionsResponse createSetNLSOptionsResponse() {
        return new SetNLSOptionsResponse();
    }

    /**
     * Create an instance of {@link SubmitRecurringRequest }
     * 
     */
    public SubmitRecurringRequest createSubmitRecurringRequest() {
        return new SubmitRecurringRequest();
    }

    /**
     * Create an instance of {@link DeleteRequest }
     * 
     */
    public DeleteRequest createDeleteRequest() {
        return new DeleteRequest();
    }

    /**
     * Create an instance of {@link RequestParameter }
     * 
     */
    public RequestParameter createRequestParameter() {
        return new RequestParameter();
    }

    /**
     * Create an instance of {@link PostProcessAction }
     * 
     */
    public PostProcessAction createPostProcessAction() {
        return new PostProcessAction();
    }

    /**
     * Create an instance of {@link RequestParameters }
     * 
     */
    public RequestParameters createRequestParameters() {
        return new RequestParameters();
    }

    /**
     * Create an instance of {@link RequestExecutionContext }
     * 
     */
    public RequestExecutionContext createRequestExecutionContext() {
        return new RequestExecutionContext();
    }

    /**
     * Create an instance of {@link StepArgs }
     * 
     */
    public StepArgs createStepArgs() {
        return new StepArgs();
    }

    /**
     * Create an instance of {@link NlsOptions }
     * 
     */
    public NlsOptions createNlsOptions() {
        return new NlsOptions();
    }

    /**
     * Create an instance of {@link MetadataObjectId }
     * 
     */
    public MetadataObjectId createMetadataObjectId() {
        return new MetadataObjectId();
    }

    /**
     * Create an instance of {@link RequestDetail }
     * 
     */
    public RequestDetail createRequestDetail() {
        return new RequestDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRequestStateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "getRequestStateResponse")
    public JAXBElement<GetRequestStateResponse> createGetRequestStateResponse(GetRequestStateResponse value) {
        return new JAXBElement<GetRequestStateResponse>(_GetRequestStateResponse_QNAME, GetRequestStateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "submitRequest")
    public JAXBElement<SubmitRequest> createSubmitRequest(SubmitRequest value) {
        return new JAXBElement<SubmitRequest>(_SubmitRequest_QNAME, SubmitRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitRecurringRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "submitRecurringRequestResponse")
    public JAXBElement<SubmitRecurringRequestResponse> createSubmitRecurringRequestResponse(SubmitRecurringRequestResponse value) {
        return new JAXBElement<SubmitRecurringRequestResponse>(_SubmitRecurringRequestResponse_QNAME, SubmitRecurringRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnJobCompletion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "onJobCompletion")
    public JAXBElement<OnJobCompletion> createOnJobCompletion(OnJobCompletion value) {
        return new JAXBElement<OnJobCompletion>(_OnJobCompletion_QNAME, OnJobCompletion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNLSOptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "setNLSOptions")
    public JAXBElement<SetNLSOptions> createSetNLSOptions(SetNLSOptions value) {
        return new JAXBElement<SetNLSOptions>(_SetNLSOptions_QNAME, SetNLSOptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAsyncRequestStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "setAsyncRequestStatusResponse")
    public JAXBElement<SetAsyncRequestStatusResponse> createSetAsyncRequestStatusResponse(SetAsyncRequestStatusResponse value) {
        return new JAXBElement<SetAsyncRequestStatusResponse>(_SetAsyncRequestStatusResponse_QNAME, SetAsyncRequestStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "deleteRequestResponse")
    public JAXBElement<DeleteRequestResponse> createDeleteRequestResponse(DeleteRequestResponse value) {
        return new JAXBElement<DeleteRequestResponse>(_DeleteRequestResponse_QNAME, DeleteRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSubmitArgsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "setSubmitArgsResponse")
    public JAXBElement<SetSubmitArgsResponse> createSetSubmitArgsResponse(SetSubmitArgsResponse value) {
        return new JAXBElement<SetSubmitArgsResponse>(_SetSubmitArgsResponse_QNAME, SetSubmitArgsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRequestDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "getRequestDetailResponse")
    public JAXBElement<GetRequestDetailResponse> createGetRequestDetailResponse(GetRequestDetailResponse value) {
        return new JAXBElement<GetRequestDetailResponse>(_GetRequestDetailResponse_QNAME, GetRequestDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurgeRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "purgeRequestResponse")
    public JAXBElement<PurgeRequestResponse> createPurgeRequestResponse(PurgeRequestResponse value) {
        return new JAXBElement<PurgeRequestResponse>(_PurgeRequestResponse_QNAME, PurgeRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPPActionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "addPPActionsResponse")
    public JAXBElement<AddPPActionsResponse> createAddPPActionsResponse(AddPPActionsResponse value) {
        return new JAXBElement<AddPPActionsResponse>(_AddPPActionsResponse_QNAME, AddPPActionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "RequestNotFoundException")
    public JAXBElement<RequestNotFoundException> createRequestNotFoundException(RequestNotFoundException value) {
        return new JAXBElement<RequestNotFoundException>(_RequestNotFoundException_QNAME, RequestNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitRecurringRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "submitRecurringRequest")
    public JAXBElement<SubmitRecurringRequest> createSubmitRecurringRequest(SubmitRecurringRequest value) {
        return new JAXBElement<SubmitRecurringRequest>(_SubmitRecurringRequest_QNAME, SubmitRecurringRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "deleteRequest")
    public JAXBElement<DeleteRequest> createDeleteRequest(DeleteRequest value) {
        return new JAXBElement<DeleteRequest>(_DeleteRequest_QNAME, DeleteRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurgeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "purgeRequest")
    public JAXBElement<PurgeRequest> createPurgeRequest(PurgeRequest value) {
        return new JAXBElement<PurgeRequest>(_PurgeRequest_QNAME, PurgeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNLSOptionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "setNLSOptionsResponse")
    public JAXBElement<SetNLSOptionsResponse> createSetNLSOptionsResponse(SetNLSOptionsResponse value) {
        return new JAXBElement<SetNLSOptionsResponse>(_SetNLSOptionsResponse_QNAME, SetNLSOptionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStepsArgsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "setStepsArgsResponse")
    public JAXBElement<SetStepsArgsResponse> createSetStepsArgsResponse(SetStepsArgsResponse value) {
        return new JAXBElement<SetStepsArgsResponse>(_SetStepsArgsResponse_QNAME, SetStepsArgsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckInCancelling }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "checkInCancelling")
    public JAXBElement<CheckInCancelling> createCheckInCancelling(CheckInCancelling value) {
        return new JAXBElement<CheckInCancelling>(_CheckInCancelling_QNAME, CheckInCancelling.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "releaseRequestResponse")
    public JAXBElement<ReleaseRequestResponse> createReleaseRequestResponse(ReleaseRequestResponse value) {
        return new JAXBElement<ReleaseRequestResponse>(_ReleaseRequestResponse_QNAME, ReleaseRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompletionStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "getCompletionStatus")
    public JAXBElement<GetCompletionStatus> createGetCompletionStatus(GetCompletionStatus value) {
        return new JAXBElement<GetCompletionStatus>(_GetCompletionStatus_QNAME, GetCompletionStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoldRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "holdRequestResponse")
    public JAXBElement<HoldRequestResponse> createHoldRequestResponse(HoldRequestResponse value) {
        return new JAXBElement<HoldRequestResponse>(_HoldRequestResponse_QNAME, HoldRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRequestState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "getRequestState")
    public JAXBElement<GetRequestState> createGetRequestState(GetRequestState value) {
        return new JAXBElement<GetRequestState>(_GetRequestState_QNAME, GetRequestState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoldRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "holdRequest")
    public JAXBElement<HoldRequest> createHoldRequest(HoldRequest value) {
        return new JAXBElement<HoldRequest>(_HoldRequest_QNAME, HoldRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStepsArgs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "setStepsArgs")
    public JAXBElement<SetStepsArgs> createSetStepsArgs(SetStepsArgs value) {
        return new JAXBElement<SetStepsArgs>(_SetStepsArgs_QNAME, SetStepsArgs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRequestExecutionContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "getRequestExecutionContext")
    public JAXBElement<GetRequestExecutionContext> createGetRequestExecutionContext(GetRequestExecutionContext value) {
        return new JAXBElement<GetRequestExecutionContext>(_GetRequestExecutionContext_QNAME, GetRequestExecutionContext.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "ValidationException")
    public JAXBElement<ValidationException> createValidationException(ValidationException value) {
        return new JAXBElement<ValidationException>(_ValidationException_QNAME, ValidationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IllegalStateException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "IllegalStateException")
    public JAXBElement<IllegalStateException> createIllegalStateException(IllegalStateException value) {
        return new JAXBElement<IllegalStateException>(_IllegalStateException_QNAME, IllegalStateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotAllowedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "NotAllowedException")
    public JAXBElement<NotAllowedException> createNotAllowedException(NotAllowedException value) {
        return new JAXBElement<NotAllowedException>(_NotAllowedException_QNAME, NotAllowedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSubmitArgs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "setSubmitArgs")
    public JAXBElement<SetSubmitArgs> createSetSubmitArgs(SetSubmitArgs value) {
        return new JAXBElement<SetSubmitArgs>(_SetSubmitArgs_QNAME, SetSubmitArgs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "submitRequestResponse")
    public JAXBElement<SubmitRequestResponse> createSubmitRequestResponse(SubmitRequestResponse value) {
        return new JAXBElement<SubmitRequestResponse>(_SubmitRequestResponse_QNAME, SubmitRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckInCancellingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "checkInCancellingResponse")
    public JAXBElement<CheckInCancellingResponse> createCheckInCancellingResponse(CheckInCancellingResponse value) {
        return new JAXBElement<CheckInCancellingResponse>(_CheckInCancellingResponse_QNAME, CheckInCancellingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "releaseRequest")
    public JAXBElement<ReleaseRequest> createReleaseRequest(ReleaseRequest value) {
        return new JAXBElement<ReleaseRequest>(_ReleaseRequest_QNAME, ReleaseRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "cancelRequest")
    public JAXBElement<CancelRequest> createCancelRequest(CancelRequest value) {
        return new JAXBElement<CancelRequest>(_CancelRequest_QNAME, CancelRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IllegalArgumentException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "IllegalArgumentException")
    public JAXBElement<IllegalArgumentException> createIllegalArgumentException(IllegalArgumentException value) {
        return new JAXBElement<IllegalArgumentException>(_IllegalArgumentException_QNAME, IllegalArgumentException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAsyncRequestStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "setAsyncRequestStatus")
    public JAXBElement<SetAsyncRequestStatus> createSetAsyncRequestStatus(SetAsyncRequestStatus value) {
        return new JAXBElement<SetAsyncRequestStatus>(_SetAsyncRequestStatus_QNAME, SetAsyncRequestStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPPActions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "addPPActions")
    public JAXBElement<AddPPActions> createAddPPActions(AddPPActions value) {
        return new JAXBElement<AddPPActions>(_AddPPActions_QNAME, AddPPActions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RuntimeServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "RuntimeServiceException")
    public JAXBElement<RuntimeServiceException> createRuntimeServiceException(RuntimeServiceException value) {
        return new JAXBElement<RuntimeServiceException>(_RuntimeServiceException_QNAME, RuntimeServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitInstantRecurringRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "submitInstantRecurringRequest")
    public JAXBElement<SubmitInstantRecurringRequest> createSubmitInstantRecurringRequest(SubmitInstantRecurringRequest value) {
        return new JAXBElement<SubmitInstantRecurringRequest>(_SubmitInstantRecurringRequest_QNAME, SubmitInstantRecurringRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRequestDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "getRequestDetail")
    public JAXBElement<GetRequestDetail> createGetRequestDetail(GetRequestDetail value) {
        return new JAXBElement<GetRequestDetail>(_GetRequestDetail_QNAME, GetRequestDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitInstantRecurringRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "submitInstantRecurringRequestResponse")
    public JAXBElement<SubmitInstantRecurringRequestResponse> createSubmitInstantRecurringRequestResponse(SubmitInstantRecurringRequestResponse value) {
        return new JAXBElement<SubmitInstantRecurringRequestResponse>(_SubmitInstantRecurringRequestResponse_QNAME, SubmitInstantRecurringRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRequestExecutionContextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "getRequestExecutionContextResponse")
    public JAXBElement<GetRequestExecutionContextResponse> createGetRequestExecutionContextResponse(GetRequestExecutionContextResponse value) {
        return new JAXBElement<GetRequestExecutionContextResponse>(_GetRequestExecutionContextResponse_QNAME, GetRequestExecutionContextResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/scheduler", name = "cancelRequestResponse")
    public JAXBElement<CancelRequestResponse> createCancelRequestResponse(CancelRequestResponse value) {
        return new JAXBElement<CancelRequestResponse>(_CancelRequestResponse_QNAME, CancelRequestResponse.class, null, value);
    }

}
