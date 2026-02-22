# TRD - Technical Requirements

## 1. Architecture Constraints
- AWS-first managed services.
- Encryption in transit and at rest mandatory.
- Least-privilege IAM policies.

## 2. Recommended Technical Stack
- Ingestion: S3, API Gateway/Lambda (optional), Kinesis Data Streams/Firehose
- Processing: AWS Glue
- Metadata: Glue Data Catalog
- Query/Analytics: Athena, QuickSight
- Optional search: OpenSearch
- Monitoring/Audit: CloudWatch, CloudTrail
- Security/Governance: IAM, KMS, Lake Formation

## 3. Non-Functional Requirements
- Availability target: 99.9% for critical ingestion path
- Data freshness: 95% <= 15 min to queryable
- Dashboard SLA: <= 30 min
- Scalability: horizontal scaling for streaming and transform workloads

## 4. Data Requirements
- Raw, staged (optional), curated zones
- Partitioning strategy by source/date/domain
- Schema versioning and evolution controls

## 5. Security Requirements
- KMS-managed keys for S3 and services
- IAM role separation by pipeline and environment
- Audit trail for admin/data access actions

## 6. Operational Requirements
- Alerting thresholds for lag, failures, and SLA breach
- DLQ and replay process
- Cost monitoring by dataset/pipeline/tag
